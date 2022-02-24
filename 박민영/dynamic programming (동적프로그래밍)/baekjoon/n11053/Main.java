/*
 * @author Minyeong Park
 * @date 2022.02.22.
 * 포도주 시식
 * https://www.acmicpc.net/problem/2156
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        String arrayStr = br.readLine();         // 수열을 일단 문자열로 받음
        StringTokenizer st = new StringTokenizer(arrayStr, " ");
        int[] array = new int[n+1];

        for (int i = 1; i <= n; i++) { // 수열을 배열에 넣음
            array[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[n+1];      // 부분 수열의 최대 길이

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;      // 일단 1개는 부분수열에 들어가므로 1로 설정
            for (int j = 1; j < i; j++) { // i번째 수 이전의 수들을 고려해서 이 숫자보다 작은 게 있었는지 파악 필요
                if (array[j] < array[i] && dp[i] <= dp[j]) // 숫자가 크고, 부분 수열의 수가 같거나 큰 게 있는지
                    dp[i] = dp[j] + 1;
            }
        }

        int max = dp[1];
        for (int i = 1; i <= n; i++) {
            if (dp[i] > max) max = dp[i];
        }
        bw.write(String.format("%d",max));
        bw.flush();
    }
}