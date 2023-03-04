/*
 * @author Minyeong Park
 * @date 2023.03.01.~05.
 * 합분해
 * 초반 원리 참고 : https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-2225-%EC%9E%90%EB%B0%94-%ED%95%A9%EB%B6%84%ED%95%B4-BOJ-2225-JAVA
 * 문제 링크 : https://www.acmicpc.net/problem/2225
 */



import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[k+1][n+1];

        // 아래와 같이 설정하도록 초기화함
        // 0   1 2 3 4 5 6 ...
        //   ----------------
        // 0 | 0 0 0 0 0 0
        // 1 | 1 1 1 1 1 1
        // 2 | 1 0 0 0 0 0
        // 3 | 1 0 0 0 0 0

        for (int i = 1; i <= k; i++) { // 세로로 1 들어가야 하는 부분
            dp[i][0] = 1;
        }

        for (int i = 0; i <= n; i++) { // 가로로 1 들어가야 하는 부분
            dp[1][i] = 1;
        }

        for (int x = 2; x <= k; x++) {
            for (int y = 1; y <= n; y++) {
                for (int i = 0; i <= y; i++) { // 이렇게 for문을 한번 더 돌지 말고 더 간단히 dp[x][y] = dp[x][y-1] + dp[x-1][y]로 풀 수 있다! (풀이2 참고)
                    dp[x][y] = (dp[x][y] + dp[x-1][i]) % 1000000000;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}