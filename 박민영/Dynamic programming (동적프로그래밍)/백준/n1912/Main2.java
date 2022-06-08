/*
 * @author Minyeong Park
 * @date 2022.06.08.
 * 연속합 (Top-Down)
 * 풀이 참고 : https://st-lab.tistory.com/140
 * 문제 링크 : https://www.acmicpc.net/problem/1912
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        dp = new Integer[n]; // 해당 인덱스까지의 최댓값을 저장하는 배열
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        recur(n - 1);
        System.out.println(max);
    }

    static int recur(int N) {
        // 탐색하지 않은 인덱스라면
        if (dp[N] == null) {
            // (이전 배열의 누적합 + 현재 값)과 현재 값을 비교하여 최댓값을 N위치에 저장
            dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
            max = Math.max(max, dp[N]);
        }
        return dp[N];
    }
}