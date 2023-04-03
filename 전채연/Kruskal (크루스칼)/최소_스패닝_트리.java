/*
    백준 1197번 : 최소 스패닝 트리
    - 문제 유형 : 그래프 이론, 최소 스패닝 트리
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 최소_스패닝_트리 {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int nodeA;
        int nodeB;
        int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            if (this.cost > other.cost) return 1;
            else if (this.cost < other.cost) return -1;
            return 0;
        }
    }

    /** 부모 정점 반환 */
    static int findParent(int v) {
        if (parent[v] == v) return v;
        return parent[v] = findParent(parent[v]);
    }

    /** 합집합 연산 수행 */
    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수 V 입력
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수 E 입력
        parent = new int[V + 1];
        List<Edge> edges = new ArrayList<>();

        // 부모 테이블 초기화
        for (int i = 1; i <= V; i++) parent[i] = i;

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 정점 A의 번호 입력
            int B = Integer.parseInt(st.nextToken()); // 정점 B의 번호 입력
            int C = Integer.parseInt(st.nextToken()); // 간선의 가중치 C 입력
            edges.add(new Edge(A, B, C));
        }

        // 가중치 기준으로 간선 오름차순 정렬
        Collections.sort(edges);

        long result = 0;
        for (int i = 0; i < E; i++) {
            Edge next = edges.get(i);
            if (findParent(next.nodeA) != findParent(next.nodeB)) {
                union(next.nodeA, next.nodeB);
                result += next.cost;
            }
        }

        // 최소 스패닝 트리의 가중치 출력
        System.out.println(result);
    }
}
