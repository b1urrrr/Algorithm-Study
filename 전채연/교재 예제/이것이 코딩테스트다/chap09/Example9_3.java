package chap09;

import java.util.*;

public class Example9_3 {
    static final int INF = (int) 1e9;
    // 노드의 개수 n, 간선의 개수 m
    static int n, m;
    // 최단 거리 테이블
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노드의 개수 입력
        int m = sc.nextInt(); // 간선의 개수 입력
        graph = new int[n + 1][n + 1];

        // 최단 거리 테이블 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 시작노드와 종료노드가 같은 경우 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int distance = sc.nextInt();
            graph[from][to] = distance;
        }

        // 플로이드 워셜 알고리즘 실행 (a -> b와 a -> i -> b 비교)
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        // 수행 결과 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 연결되지 않은 경우
                if (graph[i][j] == INF) {
                    System.out.print("INFINITY ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
