/*
    백준 11085번 : 군사 이동
    - 문제 유형 : 자료 구조, 그래프 이론, 그래프 탐색, 분리 집합
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 군사_이동 {
    static int[] parent;

    static class Path implements Comparable<Path> {
        int start;
        int end;
        int width;

        public Path(int start, int end, int width) {
            this.start = start;
            this.end = end;
            this.width = width;
        }

        @Override
        public int compareTo(Path other) {
            return other.width - this.width;
        }
    }

    static int findParent(int path) {
        if (parent[path] == path) return path;
        return parent[path] = findParent(parent[path]);
    }

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 지점의 개수 p 입력
        int w = Integer.parseInt(st.nextToken()); // 길의 개수 w 입력
        parent = new int[p + 1];

        for (int i = 1; i <= p; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // Baekjoon World의 수도 c 입력
        int v = Integer.parseInt(st.nextToken()); // Cube World의 수도 v 입력

        ArrayList<Path> edges = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작 지점 입력
            int end = Integer.parseInt(st.nextToken()); // 끝 지점 입력
            int width = Integer.parseInt(st.nextToken()); // 길의 너비 입력
            edges.add(new Path(start, end, width));
        }

        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            int start = edges.get(i).start;
            int end = edges.get(i).end;
            int width = edges.get(i).width;

            if (findParent(start) != findParent(end)) union(start, end);

            if (findParent(c) == findParent(v)) {
                // 경로 상에 있는 길 중 너비가 가장 좁은 길의 너비 출력
                System.out.println(width);
                return;
            }
        }
    }
}
