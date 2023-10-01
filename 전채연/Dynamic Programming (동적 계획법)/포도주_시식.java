/*
    백준 2156번 : 포도주 시식
    - 문제 유형 : 동적 계획법
*/

import java.io.*;

public class 포도주_시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 포도잔의 개수 n 입력
        int[] wines = new int[n + 1];
        int[] dp = new int[n + 1];

        // 포도주의 양 입력
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wines[1];
        if (n > 1) {
            dp[2] = dp[1] + wines[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] , Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
        }

        // 최대로 마실 수 있는 포도주의 양 출력
        System.out.println(dp[n]);
    }
}
