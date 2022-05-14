/*
 * @author Minyeong Park
 * @date 2022.02.27.
 * 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); //총 무게
        int[] dp = new int[n+1]; // 배달하는 봉지의 최소 개수

        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        if (n >= 4) dp[4] = -1;
        if (n >= 5) dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            dp[i] = 5001; //일단 큰 숫자로 초기화
            for (int j = 1; j <= (i-1)/2; j++) {
                if (dp[j] != -1 && dp[i-j] != -1) {
                    if (dp[i] > dp[j] + dp[i-j])
                        dp[i] = dp[j] + dp[i-j];
                }
            }
            if ((i - 1) % 2 != 0) { // i가 짝수인 경우에 대해 i보다 작은 수 중 가운데 수를 *2하는 경우
                if (dp[i/2] != -1) {
                    if (dp[i] > dp[i/2] * 2)
                        dp[i] = dp[i/2] * 2;
                }
            }

            if (dp[i] == 5001) dp[i] = -1; //아무것도 해당이 안 된 것이므로 -1로 설정
        }
        bw.write(String.format("%d", dp[n]));
        bw.flush();

    }
}