/*
    백준 9663번 : N-Queen
    - 문제 유형 : 백트래킹, 브루트포스
*/

import java.io.*;

public class N_Queen {
    static boolean[][] board;
    static int N, count = 0;

    // 백트래킹 함수
    static void backtracking(int depth) {
        A : for (int i = 0; i < N; i++) {
            // 가로줄에 퀸이 있는 경우 무시
            for (int j = 0; j < N; j++) {
                if (board[depth][j]) continue A;
            }

            // 세로줄에 퀸이 있는 경우 무시
            for (int j = 0; j < N; j++) {
                if (board[j][i]) continue A;
            }

            // 대각선(/)에 퀸이 있는 경우 무시
            for (int x = depth, y = i; x >= 0 && x < N && y >= 0 && y < N; x++, y--) {
                if (board[x][y]) continue A;
            }
            for (int x = depth, y = i; x >= 0 && x < N && y >= 0 && y < N; x--, y++) {
                if (board[x][y]) continue A;  
            }

            // 대각선(\)에 퀸이 있는 경우 무시
            for (int x = depth, y = i; x >= 0 && x < N && y >= 0 && y < N; x++, y++) {
                if (board[x][y]) continue A;
            }
            for (int x = depth, y = i; x >= 0 && x < N && y >= 0 && y < N; x--, y--) {
                if (board[x][y]) continue A;  
            }

            // 좌표 (depth, i)에 퀸 놓기
            if (depth == N - 1) count++;
            else { 
                board[depth][i] = true;
                backtracking(depth + 1);
                board[depth][i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이 N 입력
        board = new boolean[N][N];

        // 백트래킹
        backtracking(0);

        // 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수 출력
        System.out.println(count);
    }
}