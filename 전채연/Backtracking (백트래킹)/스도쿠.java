/*
    백준 2239번 : 스도쿠
    - 문제 유형 : 구현, 백트래킹
*/

import java.io.*;

public class 스도쿠 {
    static final int BOARD_SIZE = 9;
    static int[][] inital = new int[BOARD_SIZE][BOARD_SIZE];
    static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    /** 백트래킹 후 성공 여부 반환 */
    static private boolean backtracking(int x, int y) {
        if (inital[x][y] != 0) {
            if (x == BOARD_SIZE - 1 && y == BOARD_SIZE - 1) return true;
            int nx = (y == BOARD_SIZE - 1)? x + 1 : x;
            int ny = (y == BOARD_SIZE - 1)? 0 : y + 1;
            if (backtracking(nx, ny)) return true;
            return false;
        }

        NUM : for (int num = 1; num <= BOARD_SIZE; num++) {
            // 같은 칸 검증
            if (!isValidSection(x, y, num)) continue;
            
            // 가로 및 세로 검증
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[x][i] == num || board[i][y] == num) continue NUM;
            }

            // 마지막 칸이면 true 반환
            board[x][y] = num;
            if (x == BOARD_SIZE - 1 && y == BOARD_SIZE - 1) return true;

            // 백트래킹 (true면 바로 return)
            int nx = (y == BOARD_SIZE - 1)? x + 1 : x;
            int ny = (y == BOARD_SIZE - 1)? 0 : y + 1;
            if (backtracking(nx, ny)) return true;

            // 채웠던 숫자 초기화 후 반환
            if (inital[x][y] != 0) continue;
            board[x][y] = 0;
        }
        return false;
    }

    /** 같은 칸 검증 */
    static private boolean isValidSection(int x, int y, int num) {
        int sx = (x / 3) * 3;
        int sy = (y / 3) * 3;

        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 입력
        for (int i = 0; i < BOARD_SIZE; i++) {
        String column = br.readLine();
            for (int j = 0; j < BOARD_SIZE; j++) {
                inital[i][j] = column.charAt(j) - '0';
                board[i][j] = inital[i][j];
            }
        }

        backtracking(0, 0);

        // 9개의 줄에 9개의 숫자로 답 출력
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
