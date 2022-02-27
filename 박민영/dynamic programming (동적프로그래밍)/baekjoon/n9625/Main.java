/*
 * @author Minyeong Park
 * @date 2022.02.27.
 * BABBA
 * https://www.acmicpc.net/problem/9625
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k= Integer.parseInt(br.readLine());

        int[][] dp = new int[k+1][2]; // 0번 인덱스 행은 A의 개수, 1번 인덱스 행은 B의 개수

        dp[0][0] = 1; // 0번 눌렀을 때의 A의 개수
        dp[0][1] = 0; // 0번 눌렀을 때의 B의 개수

        for (int i = 1; i <= k; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] + dp[i-1][1];
        }

        bw.write(String.format("%d %d", dp[k][0], dp[k][1]));

        bw.flush();

    }
}