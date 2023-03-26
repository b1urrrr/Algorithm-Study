/*
    백준 2162번 : 선분 그룹
    - 문제 유형 : 자료 구조, 기하학, 분리 집합, 선분 교차 판정
*/

import java.io.*;
import java.util.*;

public class 선분_그룹 {
    static int N, count, max = 1;
    static int[][] parent;
    static Line[] lines;

    /** 좌표 클래스 */
    static class Coordinate implements Comparable<Coordinate> {
        long x;
        long y;

        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate other) {
            if (this.x == other.x) {
                return Long.compare(this.y, other.y);
            }
            return Long.compare(this.x, other.x);
        }
    }

    /** 직선 클래스 */
    static class Line {
        Coordinate c1;
        Coordinate c2;

        public Line(Coordinate c1, Coordinate c2) {
            this.c1 = c1;
            this.c2 = c2;
            this.sort();
        }

        /** 좌표 정렬 */
        public void sort() {
            if (c1.compareTo(c2) <= 0) return;

            Coordinate temp = c1;
            c1 = c2;
            c2 = temp;
        }
    }

    /** 부모 노드 반환 */
    static int findParent(int line) {
        if (parent[line][0] == line) return line;
        return parent[line][0] = findParent(parent[line][0]);
    }

    /** 합집합 연산 수행 */
    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a == b) return;

        if (a < b) {
            parent[b][0] = a;
            parent[a][1] += parent[b][1];
            if (parent[max][1] < parent[a][1]) max = a;
        } else {
            parent[a][0] = b;
            parent[b][1] += parent[a][1];
            if (parent[max][1] < parent[b][1]) max = b;
        }
        count--;
    }

    /** 세 점의 방향 관계가 반시계 방향이면 1, 시계 방향이면 -1, 일직선에 위치하면 0 반환 */
    static int ccw(Coordinate c1, Coordinate c2, Coordinate c3) {
        long s = c1.x * c2.y + c2.x * c3.y + c3.x * c1.y;
        s -= c1.y * c2.x + c2.y * c3.x + c3.y * c1.x;

        return Long.compare(s, 0);
    }

    /** 한 선분의 끝 점이 다른 선분이나 끝 점 위에 있는 여부 반환 */
    static boolean isInside(Coordinate c1, Coordinate c2, Coordinate c3) {
        return c1.compareTo(c3) == 0 || c2.compareTo(c3) == 0 || c1.compareTo(c3) == c3.compareTo(c2);
    }

    /** 선분 교차 여부 반환 */
    static boolean isIntersect(Line l1, Line l2) {
        int ccwl1c1 = ccw(l1.c1, l1.c2, l2.c1);
        if (ccwl1c1 == 0 && isInside(l1.c1, l1.c2, l2.c1)) return true;
        int ccwl1c2 = ccw(l1.c1, l1.c2, l2.c2);
        if (ccwl1c2 == 0 && isInside(l1.c1, l1.c2, l2.c2)) return true;
        int ccwl2c1 = ccw(l2.c1, l2.c2, l1.c1);
        if (ccwl2c1 == 0 && isInside(l2.c1, l2.c2, l1.c1)) return true;
        int ccwl2c2 = ccw(l2.c1, l2.c2, l1.c2);
        if (ccwl2c2 == 0 && isInside(l2.c1, l2.c2, l1.c2)) return true;

        int ccw1 = ccwl1c1 * ccwl1c2;
        int ccw2 = ccwl2c1 * ccwl2c2;

        // 두 직선이 일직선 상에 존재하는 경우 포개어지는지 검사
        if (ccw1 == 0 && ccw2 == 0) {
            return l2.c1.compareTo(l1.c2) <= 0 && l1.c1.compareTo(l2.c2) <= 0;
        }

        return ccw1 < 0 && ccw2 < 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 선분의 개수 N 입력
        count = N;
        parent = new int[N + 1][2]; // 0: 부모 노드 번호, 1: 그룹에 속한 선분의 개수
        lines = new Line[N + 1];

        for (int i = 1; i <= N; i++) {
            // 부모 테이블 초기화
            parent[i][0] = i;
            parent[i][1] = 1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken()); // x1 입력
            long y1 = Long.parseLong(st.nextToken()); // y1 입력
            long x2 = Long.parseLong(st.nextToken()); // x2 입력
            long y2 = Long.parseLong(st.nextToken()); // y2 입력
            lines[i] = new Line(new Coordinate(x1, y1), new Coordinate(x2, y2));
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isIntersect(lines[i], lines[j])) union(i, j);
            }
        }

        System.out.println(count); // 그룹의 수 출력
        System.out.println(parent[max][1]); // 가장 크기가 큰 그룹에 속한 선분의 개수 출력
    }
}
