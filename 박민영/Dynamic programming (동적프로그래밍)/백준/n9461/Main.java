/*
 * @author Minyeong Park
 * @date 2022.05.15.
 * 파도반 수열
 * 문제 링크 : https://www.acmicpc.net/problem/9461
 */

import java.io.*;
import java.util.Arrays;

public class Main {
    static long[] dp;
    static long triangle(int N) {
        if (dp[N] == -1) {
            dp[N] = triangle(N-2) + triangle(N-3);
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            dp = new long[N+1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            dp[1] = 1;
            if (N >= 2) {
                dp[2] = 1;
            }
            System.out.println(triangle(N));
        }
    }
}