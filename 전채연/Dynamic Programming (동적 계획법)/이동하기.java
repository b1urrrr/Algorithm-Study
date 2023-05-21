/*
    백준 11048번 : 이동하기
    - 문제 유형 : 다이나믹 프로그래밍
*/

import java.io.*;
import java.util.*;

public class 이동하기 {
    static int[] dx = {0, -1, -1};
    static int[] dy = {-1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 미로의 높이 N 입력
        int M = Integer.parseInt(st.nextToken()); // 미로의 너비 M 입력
        int[][] miro = new int[N][M];
        int[][] dp = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(st.nextToken()); // 사탕의 개수 입력
                dp[i][j] = miro[i][j];
                for (int d = 0; d < 3; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    // 미로에서 벗어난 경우
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    dp[i][j] = Math.max(dp[i][j], miro[i][j] + dp[nx][ny]);
                }
            }
        }

        // 가져올 수 있는 사탕 개수 출력
        System.out.println(dp[N - 1][M - 1]);        
    }
}
