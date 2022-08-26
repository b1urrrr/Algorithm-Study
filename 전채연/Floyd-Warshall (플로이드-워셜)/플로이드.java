/*
    백준 11404번 : 플로이드
    - 문제 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 플로이드 {
    static final int INF = (int) 1e9;
    static int[][] graph; // 최단 경로 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시의 개수 n 입력
        int m = Integer.parseInt(br.readLine()); // 버스의 개수 m 입력
        graph = new int[n + 1][n + 1];
        
        // 최단 경로 그래프 무한으로 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 시작 도시와 도착 도시가 동일한 경우 최단 경로 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        // 버스 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 버스의 시작 도시 a 입력
            int b = Integer.parseInt(st.nextToken()); // 버스의 도착 도시 b 입력
            int c = Integer.parseInt(st.nextToken()); // 한 번 타는 데 필요한 비용 c 입력
            graph[a][b] = Math.min(graph[a][b], c);
        }

        // 플로이드-워셜 알고리즘 실행
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        // 도시 i에서 j로 가는데 필요한 최소 비용 출력 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 이동 가능한 버스가 존재하지 않는 경우 0 출력
                if (graph[i][j] == INF) System.out.print("0 ");
                else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
