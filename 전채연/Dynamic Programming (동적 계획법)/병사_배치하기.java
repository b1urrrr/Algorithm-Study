/*
    백준 18353번 : 병사 배치하기
    - 문제 유형 : 동적 계획법
*/

import java.io.*;
import java.util.*;

public class 병사_배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 병사의 수 N 입력
        int[] power = new int[N];
        int[] dp = new int[N];
        int result = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            power[i] = Integer.parseInt(st.nextToken()); // 병사의 전투력 입력
            dp[i] = 1;

            // 병사의 수가 최대가 되도록 하는 경우의 수 탐색
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (power[j] > power[i]) max = Integer.max(max, dp[j]);
            }
            dp[i] += max;
            result = Math.max(result, dp[i]);
        }

        // 병사의 수가 최대가 되도록 하기 위해서 열외해야 하는 병사의 수 출력
        System.out.println(N - result);
    }
}
