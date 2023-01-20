/*
    백준 24417번 : 알고리즘 수업 - 피보나치 수 2
    - 문제 유형 : 동적 계획법
*/

import java.io.*;

public class 알고리즘_수업_피보나치_수_2 {
    static final int MAX = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n 입력
        int[] dp = new int[n + 1];

        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % MAX;

        // 코드1 코드2 실행 횟수를 1,000,000,007로 나눈 나머지 출력
        System.out.println(dp[n] + " " + (n - 2));
    }
}
