/*
 * @author Minyeong Park
 * @date 2022.05.25.
 * 계단 오르기
 * 문제 링크 : https://www.acmicpc.net/problem/2579
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n];
        System.out.println(max_count(n));
    }

    static int max_count(int n) {
        dp[0] = stairs[0];
        if (n > 1)
            dp[1] = stairs[0] + stairs[1];
        if (n > 2)
            dp[2] = (stairs[0] > stairs[1]) ? stairs[0] + stairs[2] : stairs[1] + stairs[2];

        if (n > 3) {
            for (int i = 3; i < n; i++) {
                int a = dp[i-2] + stairs[i];
                int b = dp[i-3] + stairs[i-1] + stairs[i];
                if (a > b)
                    dp[i] = a;
                else dp[i] = b;
            }
        }
        return dp[n-1];
    }
}