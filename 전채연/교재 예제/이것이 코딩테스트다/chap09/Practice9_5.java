package chap09;

import java.io.*;
import java.util.*;

public class Practice9_5 {
    static final int INF = (int) 1e9;
    static int N, M, C;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[] d;

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드 처리
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int distance = node.distance;

            // 이미 처리된 경우 무시
            if (d[index] < distance) continue;
            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = d[index] + graph.get(index).get(i).distance;
                if (cost < d[graph.get(index).get(i).index]) {
                    d[graph.get(index).get(i).index] = cost;
                    pq.add(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수 입력
        M = Integer.parseInt(st.nextToken()); // 통로의 개수 입력
        C = Integer.parseInt(st.nextToken()); // 메시지를 보내는 도시의 번호
        d = new int[N + 1];

        // 연결 노드 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); // 송신 도시
            int Y = Integer.parseInt(st.nextToken()); // 수신 도시
            int Z = Integer.parseInt(st.nextToken()); // 메시지 전달 시간
            graph.get(X).add(new Node(Y, Z));
        }

        // 최단 거리 배열 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘 실행
        dijkstra(C);

        // 메시지를 받는 도시의 총 개수와 총 걸리는 시간
        int count = -1;
        int max = -1;
        for (int i = 1; i <= N; i++) {
            if (d[i] == INF) continue;
            count++;
            max = Math.max(max, d[i]);
        }

        System.out.printf("%d %d\n", count, max);
    }
}
