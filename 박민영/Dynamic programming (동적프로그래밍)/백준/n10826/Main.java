/*
 * @author Minyeong Park
 * @date 2022.08.25.
 * 피보나치 수 4 (Bottom-up)
 * 문제 링크 : https://www.acmicpc.net/problem/10826
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new BigInteger[10001];
//        Arrays.fill(dp, -1);
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1].add(dp[i-2]);
        }
//        System.out.println(fibo(n));
        System.out.println(dp[n]);
    }
//    static long fibo(int n) {
//        if (dp[n] != -1) {
//            return dp[n];
//        }
//        return dp[n] = fibo(n-1) + fibo(n-2);
//    }
}