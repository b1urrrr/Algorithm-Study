/*
    백준 17387번 : 선분 교차 2
    - 문제 유형 : 기하학, 많은 조건 분기, 선분 교차 판정
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class 선분_교차_2 {
    /** 좌표 클래스 */
    static class Coordinate implements Comparable<Coordinate> {
        BigInteger x;
        BigInteger y;

        public Coordinate(String x, String y) {
            this.x = new BigInteger(x);
            this.y = new BigInteger(y);
        }

        @Override
        public int compareTo(Coordinate other) {
            if (this.x.compareTo(other.x) == 0) {
                return this.y.compareTo(other.y);
            }
            return this.x.compareTo(other.x);
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

    /** 세 점의 방향 관계가 반시계 방향이면 1, 시계 방향이면 -1, 일직선에 위치하면 0 반환 */
    static int ccw(Coordinate c1, Coordinate c2, Coordinate c3) {
        BigInteger s = c1.x.multiply(c2.y).add(c2.x.multiply(c3.y)).add(c3.x.multiply(c1.y));
        s = s.subtract(c1.y.multiply(c2.x).add(c2.y.multiply(c3.x)).add(c3.y.multiply(c1.x)));

        return s.compareTo(BigInteger.ZERO);
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        Coordinate c1 = new Coordinate(st.nextToken(), st.nextToken()); // x1, y1 입력
        Coordinate c2 = new Coordinate(st.nextToken(), st.nextToken()); // x2, y2 입력

        st = new StringTokenizer(br.readLine());
        Coordinate c3 = new Coordinate(st.nextToken(), st.nextToken()); // x3, y3 입력
        Coordinate c4 = new Coordinate(st.nextToken(), st.nextToken()); // x4, y4 입력

        Line l1 = new Line(c1, c2);
        Line l2 = new Line(c3, c4);

        // l1과 l2가 교차하면 1, 아니면 0 출력
        if (isIntersect(l1, l2)) System.out.println(1);
        else System.out.println(0);
    }
}