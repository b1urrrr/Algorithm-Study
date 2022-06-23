/*
 * @author Minyeong Park
 * @date 2022.06.23.
 * 가장 긴 감소하는 부분 수열
 * 문제 링크 : https://www.acmicpc.net/problem/11722
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int bigger = arr[0];
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                    bigger = arr[j];
                } else if (arr[j] == arr[i]){
                    dp[i] = dp[j];
                } else if (arr[j] < arr[i] && bigger <= arr[i]) {
                    dp[i] = 1;
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}