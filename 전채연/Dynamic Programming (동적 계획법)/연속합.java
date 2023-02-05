/*
    백준 1912번 : 연속합
    - 문제 유형 : 동적 계획법
*/

import java.util.*;
import java.io.*;

public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n 입력
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()); // 수열 입력
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.parseInt(st.nextToken()); // 수열의 i번째 수 입력
        }

        int max = dp[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1] + dp[i], dp[i]);
            max = Math.max(max, dp[i]);
        }

        // 가장 큰 합 출력
        System.out.println(max);
    }
}
