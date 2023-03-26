/*
    백준 17396번 : 백도어
    - 문제 유형 : 그래프 이론, 데이크스트라
*/

import java.io.*;
import java.util.*;

public class 백도어 {
    static final long INF = (long) 1e11;
    static int N;
    static int[] eyesight;
    static long[] spt;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); 

    static class Node implements Comparable<Node> {
        int index;
        long time;

        Node(int index, long time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            if (this.time < other.time) return -1;
            else if (this.time > other.time) return 1;
            else return 0;
        }
    }

    /** 최소 시간 탐색 함수 */
    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        spt[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node next = pq.remove();

            // 적의 시야에 보이는 경우
            if (eyesight[next.index] == 1 && next.index != N - 1) continue;
            // 이미 처리한 노드인 경우
            if (spt[next.index] < next.time) continue;

            for (int i = 0; i < graph.get(next.index).size(); i++) {
                long cost = spt[next.index] + graph.get(next.index).get(i).time;
                if (cost < spt[graph.get(next.index).get(i).index]) {
                    spt[graph.get(next.index).get(i).index] = cost;
                    pq.add(new Node(graph.get(next.index).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 분기점의 수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 분기점들을 잇는 길의 수 M 입력
        
        spt = new long[N];
        eyesight = new int[N];
        for (int i = 0; i < N; i++) {
            spt[i] = INF;
            graph.add(new ArrayList<Node>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            eyesight[i] = Integer.parseInt(st.nextToken()); // i 번째 분기점이 상대의 시야에 보이는지 여부 입력 (0: 안 보임, 1: 보임)
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 첫 번째 분기점 a 입력
            int b = Integer.parseInt(st.nextToken()); // 두 번째 분기점 b 입력
            int t = Integer.parseInt(st.nextToken()); // a와 b 사이를 지나는 데 걸리는 시간 t 입력
            graph.get(a).add(new Node(b, t));
            graph.get(b).add(new Node(a, t));
        }

        dijkstra();

        // 유섭이의 챔피언이 상대 넥서스까지 안 들키고 가는데 걸리는 최소 시간 출력
        System.out.println((spt[N - 1] == INF)? -1 : spt[N - 1]);
    }
}