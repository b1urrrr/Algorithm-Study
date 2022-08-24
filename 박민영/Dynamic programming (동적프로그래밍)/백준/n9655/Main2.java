/*
 * @author Minyeong Park
 * @date 2022.08.24.
 * 돌 게임 (다른 풀이 공부)
 * 출처 : https://propercoding.tistory.com/21
 * 문제 링크 : https://www.acmicpc.net/problem/9655
 */

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
        }
        if (dp[n] % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}