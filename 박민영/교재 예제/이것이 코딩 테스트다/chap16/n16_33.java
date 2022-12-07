// chap16 Q.33 퇴사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n16_33 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n+1];  // 각 상담을 완료하는 데 걸리는 시간
        int[] p = new int[n+1];  // 각 상담을 완료햇을 때 받을 수 있는 금액
        int[] dp = new int[n+1]; // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) { // 날짜가 범위를 넘어가지 않는 경우
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}
