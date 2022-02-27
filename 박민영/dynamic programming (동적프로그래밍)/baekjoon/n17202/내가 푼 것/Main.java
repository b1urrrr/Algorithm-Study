/*
 * @author Minyeong Park
 * @date 2022.02.27.
 * 핸드폰 번호 궁합
 * https://www.acmicpc.net/problem/17202
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int[][] dp = new int[17][17];

        for (int i = 1; i <= 15; i += 2) { //배열에 넣기
            int num = (int) Math.pow(10,(7 - i / 2)); //한 자리수를 구하기 위해 나눌 수
            dp[0][i] = a / num;
            dp[0][i+1] = b / num;

            a %= num;
            b %= num;
        }

        for (int i = 1; i < 16; i++) {
            for (int j = 1; j <= 16 - i; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-1][j+1]) % 10;
            }
        }

        bw.write(String.format("%d%d", dp[14][1],dp[14][2]));

        bw.flush();
    }
}