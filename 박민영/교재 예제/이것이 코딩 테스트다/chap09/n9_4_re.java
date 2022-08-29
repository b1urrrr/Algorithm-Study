import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n9_4_re {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억 설정
    public static int n, m, x, k;
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b)
                    graph[a][b] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
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
        for (int k = 1; k <= n; k++) { // k : 현재 처리하는 (거쳐가는) 노드 : 1 ~ n번 노드까지 처리
            for (int a = 1; a <= n; a++) { // a와 b는 나머지 노드들 (자기 자신으로 가는 것은 0이므로 이미 최솟값)
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]); // 바로 a->b 가 더 비용이 적은지 or a->k->b가 더 비용이 적은지
                }
            }
        }

        if (graph[1][k] + graph[k][x] >= INF) { // 도달할 수 없는 경우
            System.out.println(-1);
        } else {
            System.out.println(graph[1][k] + graph[k][x]); // 도달할 수 있는 경우 최단 거리를 출력
        }
    }
}
