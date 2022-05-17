/*
 * @author Minyeong Park
 * @date 2022.05.14.
 * 01타일
 * 문제 링크 : https://www.acmicpc.net/problem/1904
 */

import java.io.*;

public class Main {
    static int[] dp;
    static int func(int N) {
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[1] = 1;
        if (N >= 2)
            dp[2] = 2;
        System.out.println(func(N));
    }
}