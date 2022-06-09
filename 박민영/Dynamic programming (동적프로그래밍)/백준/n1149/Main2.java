/*
 * @author Minyeong Park
 * @date 2022.06.09.
 * RGB거리 (재귀)
 * 원리 참고 : https://st-lab.tistory.com/128
 * 문제 링크 : https://www.acmicpc.net/problem/1149
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    final static int red = 0;
    final static int green = 1;
    final static int blue = 2;

    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        cost = new int[n][3];
        dp = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
        dp[0][red] = cost[0][red];
        dp[0][green] = cost[0][green];
        dp[0][blue] = cost[0][blue];

        int result = Math.min(Math.min(paint_cost(n-1, red), paint_cost(n-1, green)), paint_cost(n-1, blue));
        System.out.println(result);
    }

    static int paint_cost(int n, int color) {
        // 만약 탐색하지 않은 배열이라면
        if (dp[n][color] == 0) {
            if (color == red)
                dp[n][red] = Math.min(paint_cost(n-1, green), paint_cost(n-1, blue)) + cost[n][red];
            else if (color == green)
                dp[n][green] = Math.min(paint_cost(n-1, red), paint_cost(n-1, blue)) + cost[n][green];
            else
                dp[n][blue] = Math.min(paint_cost(n-1, red), paint_cost(n-1, green)) + cost[n][blue];
        }
        return dp[n][color];
    }
}