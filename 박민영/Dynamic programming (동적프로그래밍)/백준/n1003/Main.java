/*
 * @author Minyeong Park
 * @date 2022.04.30.
 * 피보나치 함수
 * 참고 : https://st-lab.tistory.com/124
 * 문제 링크 : https://www.acmicpc.net/problem/2748
 */

import java.io.*;

public class Main {
    static Integer[][] dp = new Integer[41][2];

    static Integer[] fibo(int num) {
        // num에 대한 0,1의 호출 횟수가 없을 때 (탐색하지 않은 값일 때)
        if (dp[num][0] == null || dp[num][1] == null) {
            // 각 num에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
            dp[num][0] = fibo(num - 1)[0] + fibo(num - 2)[0];
            dp[num][1] = fibo(num - 1)[1] + fibo(num - 2)[1];
        }
        return dp[num];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int input;

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < T; i++) {
            input = Integer.parseInt(br.readLine());
            fibo(input);
            bw.write(dp[input][0] + " " + dp[input][1] + "\n");
        }

        bw.flush();
    }
}