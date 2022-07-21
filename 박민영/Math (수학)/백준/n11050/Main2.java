/*
 * @author Minyeong Park
 * @date 2022.07.14.
 * 이항 계수 1 (다른 풀이 공부)
 * 출처 : https://st-lab.tistory.com/159
 * 문제 링크 : https://www.acmicpc.net/problem/11050
 */

import java.util.Scanner;

public class Main2 {
    static int n;
    static int k;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        dp = new int[n+1][k+1];
        System.out.println(BC(n,k));
    }

    static int BC(int n, int k) {
        // 이미 풀었던 문제일 경우 값을 재활용
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (n == k || k == 0) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = BC(n-1, k-1) + BC(n-1, k);
    }
}