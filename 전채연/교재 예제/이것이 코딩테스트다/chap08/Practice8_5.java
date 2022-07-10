package chap08;

import java.io.*;

public class Practice8_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1]; // DP 테이블

        for (int i = 2; i <= x; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            // 5로 나누는 경우
            if (i % 5 == 0) dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            // 3으로 나누는 경우
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            // 2로 나누는 경우
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }

        System.out.println(dp[x]);
    }
}
