/*
 * @author Minyeong Park
 * @date 2022.07.22.
 * 다리 놓기
 * 원리 참고 : https://st-lab.tistory.com/194, https://st-lab.tistory.com/159#%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * 문제 링크 : https://www.acmicpc.net/problem/1010
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(combi(m,n)).append('\n');
        }
        System.out.println(sb);
    }

    static int combi(int n, int r) {
        // 이미 탐색했던 경우 바로 반환
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
}