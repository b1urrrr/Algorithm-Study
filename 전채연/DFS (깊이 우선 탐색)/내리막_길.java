/*
    백준 1520번 : 내리막 길
    - 문제 유형 : 그래프 탐색, 다이나믹 프로그래밍
    - 풀이 유형 : DFS (깊이 우선 탐색), 다이나믹 프로그래밍
*/

import java.io.*;
import java.util.StringTokenizer;

public class 내리막_길 {
    static int m, n;
    static int[][] map, dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 깊이 우선 탐색 메서드
    static int dfs(int x, int y) {
        dp[x][y] = 0; // 계산한 적 있음을 표시

        // (x, y)에서 목적지까지의 이동 가능 경로 개수 계산
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 지도의 범위를 벗어난 경우
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            // 내리막이 아닌 경우
            if (map[x][y] <= map[nx][ny]) continue;

            // (nx, ny)에서 목적지까지의 이동 가능 경로 개수를 더함
            if (dp[nx][ny] >= 0) dp[x][y] += dp[nx][ny]; // 결과를 알고 있으면 바로 더함
            else dp[x][y] += dfs(nx, ny);
        }

        return dp[x][y];
    }

    public static void main(String[] arsg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 세로의 크기 입력
        n = Integer.parseInt(st.nextToken()); // 가로의 크기 입력
        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 지점의 높이 입력
                dp[i][j] = -1;
            }
        }

        // 목적지 dp 값 초기화
        dp[m - 1][n - 1] = 1;

        // 이동 가능한 경로의 수 출력
        System.out.println(dfs(0, 0));
    }
}