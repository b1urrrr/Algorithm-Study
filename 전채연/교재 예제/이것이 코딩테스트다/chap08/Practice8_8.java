package chap08;

import java.io.*;
import java.util.StringTokenizer;

public class Practice8_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 화폐의 종류 (1 이상 100 이하)
        int M = Integer.parseInt(st.nextToken()); // 목표 금액 (1 이상 10,000 이하)
        int[] dp = new int[M + 1]; // DP 테이블
        int[] money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine()); // 화폐의 가치 (10,000 이하)
        }
        
        for (int i = 1; i <= M; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                // money[j] 화폐를 하나 이상 사용하는 경우 저장
                if (i >= money[j])
                    dp[i] = Math.min(dp[i], dp[i - money[j]] + 1);
            }
        }

        if (dp[M] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[M]);
    }
}
