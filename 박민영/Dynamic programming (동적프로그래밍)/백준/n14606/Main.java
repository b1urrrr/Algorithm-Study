/*
 * @author Minyeong Park
 * @date 2022.09.25.
 * 피자
 * 원리 참고 : https://kangeee.tistory.com/119
 * 문제 링크 : https://www.acmicpc.net/problem/14606
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + (i-1);
        }
        System.out.println(dp[n]);
    }
}