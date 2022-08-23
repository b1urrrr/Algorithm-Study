package chap09;

import java.util.*;

public class Example9_2 {
    // 노드의 개수 n, 간선의 개수 m, 시작 노드의 번호 start
    static int n, m, start;
    // 연결 노드 그래프
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단 거리 테이블
    static int[] d;

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        // 시작 노드로부터의 최단 거리가 짧은 노드가 우선순위를 가지도록 구현
        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }

    // 다익스트라 최단 경로 알고리즘 함수
    static void dijstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드 처리
        pq.offer(new Node(start, 0));
        d[start] = 0;

        // 큐가 비워질 때까지 반복
        while(!pq.isEmpty()) {
            // 최단 거리가 가장 짧은 노드 반환
            Node node = pq.poll();
            int distance = node.distance;
            int now = node.index;

            // 이미 방문한 노드이면 무시
            if (d[now] < distance) continue;
            // 현재 노드와 연결된 다른 노드 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                // 현재 노드를 거친 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노드의 개수 입력
        int m = sc.nextInt(); // 간선의 개수 입력
        int start = sc.nextInt(); // 시작 노드의 인덱스 입력
        d = new int[n + 1];

        // 연결 노드 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int distance = sc.nextInt();
            graph.get(from).add(new Node(to, distance));
        }

        // 최단 거리 테이블 초기화 (무한)
        Arrays.fill(d, Integer.MAX_VALUE);

        // 다익스트라 알고리즘 실행
        dijstra(start);

        // 모든 노드로의 최단 거리 출력
        for (int i = 1; i <= n; i++) {
            // 연결되지 않은 경우 'INFINITY' 출력
            if (d[i] == Integer.MAX_VALUE) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }
    }
}
