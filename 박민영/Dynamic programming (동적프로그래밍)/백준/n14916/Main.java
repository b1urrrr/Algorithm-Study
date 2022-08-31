import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        Arrays.fill(dp, 100001);
        dp[1] = -1; // 1원은 아예 불가능
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;
        for (int i = 6; i <= n; i++) {
            if (dp[i-2] == -1) {
                dp[i] = dp[i-5] + 1;
                continue;
            }
            if (dp[i-5] == -1) {
                dp[i] = dp[i-2] + 1;
                continue;
            }
            dp[i] = Math.min(dp[i-2] + 1, dp[i-5] + 1);
        }
        System.out.println(dp[n]);
    }
}