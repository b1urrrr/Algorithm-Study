// chap09 (2) 실전 문제 : 미래 도시
// 해설&조금씩 코드 보면서 이해하면서 풀었다...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n9_7 {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 생성
    public static int n, m, x, k;
    public static int[][] graph = new int[101][101]; // 2차원 배열(그래프 표현)을 만들기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b)
                    graph[a][b] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) { //k : 현재 처리하는 노드(거쳐가는 노드) : 1 ~ n번 노드까지 처리
            for (int a = 1; a <= n; a++) { // a와 b는 나머지 노드들 (자기 자신으로 가는 것은 0이므로 이미 가장 최소값)
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        if (graph[1][k] + graph[k][x] >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(graph[1][k] + graph[k][x]);
        }
    }
}
