package chap09;

import java.io.*;
import java.util.*;

public class Practice9_4 {
    static final int INF = (int) 1e9;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 회사의 개수
        int M = Integer.parseInt(st.nextToken()); // 경로의 개수
        int[][] graph = new int[N + 1][N + 1];

        // 최단 거리 배열 초기화 (무한)
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 시작 노드와 종료 노드가 동일한 경우
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        // 플로이드 워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (graph[1][K] == INF || graph[K][X] == INF) System.out.println(-1);
        else System.out.println(graph[1][K] + graph[K][X]);
    }
}
