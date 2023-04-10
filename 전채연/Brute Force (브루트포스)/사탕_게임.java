/*
    백준 3085번 : 사탕 게임
    - 문제 유형 : 구현, 브루트포스 알고리즘
*/

import java.io.*;

public class 사탕_게임 {
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, max = 0;

    static int maxCandy() {
        int verticalCountMax = 1;
        int horizontalCountMax = 1;

        for (int i = 0; i < N; i++) {
            int verticalCount = 1;
            int horizontalCount = 1;

            for (int j = 1; j < N; j++) {
                if (board[i][j - 1] == board[i][j]) verticalCount++;
                else verticalCount = 1;

                if (board[j - 1][i] == board[j][i]) horizontalCount++;
                else horizontalCount = 1;

                verticalCountMax = Math.max(verticalCountMax, verticalCount);
                horizontalCountMax = Math.max(horizontalCountMax, horizontalCount);
            }
        }

        return Math.max(verticalCountMax, horizontalCountMax);
    }

    static void countCandy(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 보드 범위를 벗어난 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            // 인접한 두 칸의 사탕 색이 동일한 경우
            if (board[x][y] == board[nx][ny]) continue;

            char currentColor = board[x][y];
            char adjacentColor = board[nx][ny];
            board[nx][ny] = currentColor;
            board[x][y] = adjacentColor;
            max = Math.max(max, maxCandy());
            board[x][y] = currentColor;
            board[nx][ny] = adjacentColor;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 보드의 크기 N 입력
        board = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j); // 보드에 채워져 있는 사탕의 색상 입력
            }
        }

        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) countCandy(i, j);

        // 상근이가 먹을 수 있는 사탕의 최대 개수 출력
        System.out.println(max);
    }
}
