import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n16_31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[][] arr = new int[n][m];
            int[][] dp = new int[20][20];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                    dp[r][c] = arr[r][c];
                }
            }


            for (int c = 1; c < m; c++) {
                for (int r = 0 ; r < n; r++) {
                    int leftUp, leftDown, left;
                    // 왼쪽 위에서 오는 경우
                    if (r == 0) leftUp = 0;
                    else leftUp = dp[r-1][c-1];

                    // 왼쪽 아래에서 오는 경우
                    if (r == n-1) leftDown = 0;
                    else leftDown = dp[r+1][c-1];

                    // 왼쪽에서 오는 경우
                    left = dp[r][c-1];
                    dp[r][c] = dp[r][c] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }

            int result = 0;
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dp[j][m-1]);
            }
            System.out.println(result);
        }
    }
}
