package chap10;

import java.io.*;
import java.util.*;

public class Example10_5 {
    // 노드의 개수 v와 간선의 개수 e, 최종 비용 result 변수
    static int v, e, result;
    // 부모 테이블
    static int[] parent;
    // 간선 리스트
    static ArrayList<Edge> edges = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        int distance;
        int nodeA;
        int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public int compareTo(Edge other) {
            if (this.distance < other.distance) return -1;
            return 1;
        }
    }

    // 루트 노드 탐색 (특정 원소가 속한 집합 찾기)
    static int find(int node) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    // Union 함수
    static void union(int a, int b) {
        // 각각의 루트 노드 탐색
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); // 노드의 개수 입력
        e = Integer.parseInt(st.nextToken()); // 간선의 개수 입력
        parent = new int[v + 1];

        // 부모 테이블 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 간선 정보 입력
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            edges.add(new Edge(distance, nodeA, nodeB));
        }

        // 간선을 비용 순으로 정렬
        Collections.sort(edges);

        // 간선 처리
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).distance;
            int a = edges.get(i).nodeA;
            int b = edges.get(i).nodeB;

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (find(a) != find(b)) {
                union(a, b);
                result += cost;
            }
        }

        // 최소 신장 트리의 최소 비용 출력
        System.out.println(result);
    }
}
