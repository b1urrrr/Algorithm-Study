import java.io.*;
import java.util.StringTokenizer;

public class 내리막_길 {
    static int m, n;
    static int[][] map, dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) return 1;
        if (dp[x][y] > 0) return dp[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 지도의 범위를 벗어난 경우
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            // 내리막이 아닌 경우
            if (map[x][y] <= map[nx][ny]) continue;

            System.out.println(nx + ", " + ny);
            dp[x][y] += dfs(nx, ny);
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
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }
}