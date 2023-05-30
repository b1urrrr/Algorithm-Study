/*
    백준 1922번 : 네트워크 연결
    - 문제 유형 : 그래프 이론, 최소 스패닝 트리
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 네트워크_연결 {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Edge other) {
            return this.c - other.c;
        }
    }

    static int findParent(int computer) {
        if (computer == parent[computer]) return computer;
        return parent[computer] = findParent(parent[computer]);
    }

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수 N 입력
        int M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수 M 입력
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) parent[i] = i;
        
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 컴퓨터 a의 번호 입력
            int b = Integer.parseInt(st.nextToken()); // 컴퓨터 b의 번호 입력
            int c = Integer.parseInt(st.nextToken()); // 연결 비용 c 입력
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);

        int result = 0;
        for (int i = 0; i < M; i++) {
            Edge edge = edges.get(i);
            if (findParent(edge.a) != findParent(edge.b)) {
                union(edge.a, edge.b);
                result += edge.c;
            }
        }

        // 모든 컴퓨터를 연결하는데 필요한 최소비용 출력
        System.out.println(result);
    }
}
