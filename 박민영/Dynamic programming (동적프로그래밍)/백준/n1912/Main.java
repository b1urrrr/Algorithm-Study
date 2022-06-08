/*
 * @author Minyeong Park
 * @date 2022.06.08.
 * 연속합 (Bottom-Up)
 * 풀이 참고 : https://st-lab.tistory.com/140
 * 문제 링크 : https://www.acmicpc.net/problem/1912
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n]; // 해당 인덱스까지의 최댓값을 저장하는 배열
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}