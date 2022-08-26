import java.io.*;
import java.util.*;

public class 최소비용_구하기 {
    static final int INF = (int) 1e9;
    static int N, M, start; // 도시의 개수, 버스의 개수, 시작 도시
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); // 연결 노드 그래프
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
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        // 시작 노드 처리
        que.offer(new Node(start, 0));
        spt[start] = 0;

        while (!que.isEmpty()) {
            Node node = que.poll();
            int index = node.index;
            int distance = node.distance;

            // 이미 방문한 노드이면 무시
            if (spt[index] < distance) continue;

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = spt[index] + graph.get(index).get(i).distance;
                // 최단 거리에 해당하면 최단 거리 테이블 초기화 및 큐 삽입
                if (cost < spt[graph.get(index).get(i).index]) {
                    spt[graph.get(index).get(i).index] = cost;
                    que.add(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); // 도시의 개수 N 입력
        M = Integer.parseInt(br.readLine()); // 버스의 개수 M 입력
        spt = new int[N + 1];

        // 연결 노드 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 최단 거리 테이블 무한으로 초기화
        Arrays.fill(spt, INF);

        // 버스의 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 버스의 출발 도시 번호
            int end = Integer.parseInt(st.nextToken()); // 버스의 도착 도시 번호
            int cost = Integer.parseInt(st.nextToken()); // 그 버스의 비용
            graph.get(start).add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 출발점의 도시 번호 입력
        int end = Integer.parseInt(st.nextToken()); // 도착점의 도시 번호 입력

        // 다익스트라 알고리즘 실행
        dijkstra(start);

        // 출발 도시에서 도착 도시까지 가는데 드는 최소 비용 출력
        System.out.println(spt[end]);
    }
}
