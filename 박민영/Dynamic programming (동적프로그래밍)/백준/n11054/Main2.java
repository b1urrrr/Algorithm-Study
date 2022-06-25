/*
 * @author Minyeong Park
 * @date 2022.06.25.
 * 가장 긴 바이토닉 부분 수열 (재귀 Top-Down)
 * 원리 참고해서 풀었음 : https://st-lab.tistory.com/136
 * 문제 링크 : https://www.acmicpc.net/problem/11054
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] up_dp;
    static int[] down_dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        up_dp = new int[n];
        down_dp = new int[n];
        for (int i = 0; i < n; i++) {
            lis(i);
            lds(i);
        }

        int[] result_dp = new int[n];
        int max_count = 0;
        for (int i = 0; i < n; i++) {
            result_dp[i] = up_dp[i] + down_dp[i] - 1;
            if (max_count < result_dp[i])
                max_count = result_dp[i];
        }

        System.out.println(max_count);
    }

    static int lis(int i) {
        // 만약 탐색하지 않은 위치의 경우
        if (up_dp[i] == 0) {
            up_dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    up_dp[i] = Math.max(lis(j) + 1, up_dp[i]);
                }
            }
        }
        return up_dp[i];
    }

    static int lds(int i) {
        // 만약 탐색하지 않은 위치의 경우
        if (down_dp[i] == 0) {
            down_dp[i] = 1;

            for (int j = down_dp.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    down_dp[i] = Math.max(lds(j) + 1, down_dp[i]);
                }
            }
        }
        return down_dp[i];
    }
}