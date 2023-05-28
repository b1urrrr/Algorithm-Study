/*
    백준 6497번 : 전력난
    - 문제 유형 : 그래프 이론, 최소 스패닝 트리
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 전력난 {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int z;

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int compareTo(Edge other) {
            return this.z - other.z;
        }
    }

    static int findParent(int road) {
        if (road == parent[road]) return road;
        return parent[road] = findParent(parent[road]);
    }

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 집의 수 m 입력
            int n = Integer.parseInt(st.nextToken()); // 길의 수 n 입력
            if (m == 0 && n == 0) break;
            
            parent = new int[m];
            for (int i = 0; i < m; i++) parent[i] = i;

            int maxCost = 0;
            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 집 x의 번호 입력
                int y = Integer.parseInt(st.nextToken()); // 집 y의 번호 입력
                int z = Integer.parseInt(st.nextToken()); // 양방향 도로의 거리 z 입력
                edges.add(new Edge(x, y, z));
                maxCost += z;
            }

            Collections.sort(edges);

            int minCost = 0;
            for (int i = 0; i < n; i++) {
                Edge edge = edges.get(i);

                if (findParent(edge.x) != findParent(edge.y)) {
                    union(edge.x, edge.y);
                    minCost += edge.z;
                }
            }

            // 절약할 수 있는 최대 비용 출력
            bw.write(maxCost - minCost + "\n");
        }

        bw.flush();
    }
}
