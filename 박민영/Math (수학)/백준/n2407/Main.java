/*
 * @author Minyeong Park
 * @date 2022.10.23.
 * 조합
 * 문제 링크 : https://www.acmicpc.net/problem/2407
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[] dp = new BigInteger[n+1];
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
        }
        System.out.println(dp[n].divide(dp[m].multiply(dp[n-m])));
    }
}