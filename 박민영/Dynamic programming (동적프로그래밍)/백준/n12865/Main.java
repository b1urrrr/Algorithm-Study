/*
 * @author Minyeong Park
 * @date 2022.09.24 ~ 25.
 * 평범한 배낭
 * 원리 참고 : 설명 잘 이해됨! - https://badassdev.tistory.com/20, https://suri78.tistory.com/2
 *           잘 이해는 못했지만.. 참고 - https://st-lab.tistory.com/141, https://www.youtube.com/watch?v=uggO0uzGboY
 * 문제 링크 : https://www.acmicpc.net/problem/12865
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n+1];
        int[] v = new int[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}