/*
    백준 5972번 : 택배 배송
    - 문제 유형 : 그래프 이론, 데이크스트라
*/

import java.io.*;
import java.util.*;

public class 택배_배송 {
    static final int INF = (int) 1e9;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] spt;

    static class Node implements Comparable<Node> {
        int index;
        int count; 

        Node(int index, int count) {
            this.index = index;
            this.count = count;
        }

        @Override
        public int compareTo(Node other) {
            if (this.count < other.count) return -1;
            return 1;
        }
    }

    /** 최소 여물 개수 탐색 함수 */
    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        spt[1] = 0;

        while(!pq.isEmpty()) {
            Node next = pq.remove();

            // 이미 처리한 길인 경우
            if (spt[next.index] < next.count) continue;

            for (int i = 0; i < graph.get(next.index).size(); i++) {
                int count = spt[next.index] + graph.get(next.index).get(i).count;
                if (count < spt[graph.get(next.index).get(i).index]) {
                    spt[graph.get(next.index).get(i).index] = count;
                    pq.add(new Node(graph.get(next.index).get(i).index, count));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 헛간의 개수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 길의 개수 M 입력
        spt = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
            spt[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken()); // 헛간 A_i 입력
            int B_i = Integer.parseInt(st.nextToken()); // 헛간 B_i 입력
            int C_i = Integer.parseInt(st.nextToken()); // 소의 수 C_i 입력

            graph.get(A_i).add(new Node(B_i, C_i));
            graph.get(B_i).add(new Node(A_i, C_i));
        }

        dijkstra();

        // 농부 현서가 가져가야 될 최소 여물 출력
        System.out.println(spt[N]);
    }
}
