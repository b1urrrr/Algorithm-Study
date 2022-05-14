/*
 * @author Minyeong Park
 * @date 2022.02.27.
 * 타일 장식물
 * https://www.acmicpc.net/problem/13301
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1]; // 타일 한 변의 길이를 담는 배열

        dp[1] = 1; // 첫번째 타일의 한 변의 길이
        if (n >= 2) dp[2] = 1; // 두번째 타일의 한 변의 길이
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        long sum = 0;
        if (n == 1) sum = dp[n] * 4;
        if (n == 2) sum = dp[n] * 3 + dp[n] * 3;
        if (n == 3) sum = dp[n] * 3 + dp[n-1] * 2 + dp[n-2] * 2;
        if (n > 3) sum = dp[n] * 3 + dp[n-1] * 2 + dp[n-2] * 2 + dp[n-3];

        bw.write(String.format("%d", sum));

        bw.flush();

    }
}