/*
 * @author Minyeong Park
 * @date 2022.06.25.
 * 가장 긴 바이토닉 부분 수열 (반복문 Bottom-up)
 * 원리 참고해서 풀었음 : https://st-lab.tistory.com/136
 * 문제 링크 : https://www.acmicpc.net/problem/11054
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] up_dp = new int[n];
        for (int i = 0; i < n; i++) {
            up_dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && up_dp[i] <= up_dp[j]) {
                    up_dp[i] = up_dp[j] + 1;
                }
            }
        }

        int[] down_dp = new int[n];
        for (int i = n-1; i >= 0; i--) {
            down_dp[i] = 1;

            for (int j = n-1; j > i; j--) {
                if (arr[j] < arr[i] && down_dp[i] <= down_dp[j]) {
                    down_dp[i] = down_dp[j] + 1;
                }
            }
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
}