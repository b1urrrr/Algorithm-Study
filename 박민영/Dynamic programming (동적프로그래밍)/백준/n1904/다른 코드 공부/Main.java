/*
 * @author Minyeong Park
 * @date 2022.05.14.
 * 01타일 (다른 코드 공부)
 * 출처 : https://st-lab.tistory.com/125
 * 문제 링크 : https://www.acmicpc.net/problem/1904
 */

import java.io.*;

public class Main {
    static int[] dp = new int[1000001];
    static int func(int N) {
        if (dp[N] == -1) {
            dp[N] = (func(N-1) + func(N-2)) % 15746
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println(func(N));
    }
}