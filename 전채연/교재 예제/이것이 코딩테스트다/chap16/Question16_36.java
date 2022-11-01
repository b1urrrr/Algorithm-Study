package chap16;

import java.io.*;

public class Question16_36 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine(); // 문자열 A 입력
        String B = br.readLine(); // 문자열 B 입력

        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) dp[i][0] = i;
        for (int i = 1; i <= B.length(); i++) dp[0][i] = i;

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                // 문자가 동일한 경우
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 삽입(Insert), 삭제(Remove), 교체(Replace)하는 경우 중 최소 편집 거리 대입
                dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
            }
        }

        // 최소 편집 거리 출력
        System.out.println(dp[A.length()][B.length()]);
    }
}
