/*
    백준 1753번 : 최단경로
    - 문제 유형 : 다익스트라
*/

import java.io.*;
import java.util.*;

public class 최단경로 {
    static final int INF = (int) 1e9;
    static int V, E; // 정점의 개수, 간선의 개수
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 연결 노드 그래프
    static int[] spt; // 최단 거리 테이블 (shortest path table)

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) return -1;
            return 1;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드 처리
        pq.add(new Node(start, 0));
        spt[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.remove();
            int index = node.index;
            int distance = node.distance;

            // 이미 방문한 노드이면 무시
            if (spt[index] < distance) continue;
            
            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = spt[index] + graph.get(index).get(i).distance;
                // 최단 거리에 해당하면 최단 거리 테이블 초기화 및 큐 추가
                if (cost < spt[graph.get(index).get(i).index]) {
                    spt[graph.get(index).get(i).index] = cost;
                    pq.add(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수 V 입력
        E = Integer.parseInt(st.nextToken()); // 간선의 개수 E 입력
        int K = Integer.parseInt(br.readLine()); // 시작 정점 K 입력
        spt = new int[V + 1];

        // 연결 노드 그래프 초기화
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 최단 거리 테이블 무한으로 초기화
        Arrays.fill(spt, INF);

        // 간선의 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 정점 u 입력
            int v = Integer.parseInt(st.nextToken()); // 도착 정점 v 입력
            int w = Integer.parseInt(st.nextToken()); // 가중치 w 입력
            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라 알고리즘 실행
        dijkstra(K);

        // i번 정점으로의 최단 경로의 경로값을 출력
        for (int i = 1; i <= V; i++) {
            // 경로가 존재하지 않는 정점은 INF 출력
            if (spt[i] == INF) System.out.println("INF");
            else System.out.println(spt[i]);
        }
    }
}