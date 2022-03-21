package 연습문제;

import java.util.Arrays;

public class q8 {
    static boolean[] flag_a = new boolean[8];  // 각 행에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15];  // /대각선 방향으로 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15];  // \대각선 방향으로 퀸을 배치했는지 체크
    static int[] pos = new int[8];           // 각 열의 퀸의 위치

    static void print() {
        // 숫자로 위치 출력
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();

        // 퀸의 배치 상황 출력
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(board[i], '□'); // 배열의 요소 값을 모두 □으로 초기화
        }


        for (int i = 0; i < 8; i++) {
            board[i][pos[i]] = '■';
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%c", board[i][j]);
            }
            System.out.println();
        }
    }

    // i열의 알맞은 위치에 퀸을 배치합니다.
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (flag_a[j] == false &&              // 가로 행에 아직 배치 X
                    flag_b[i+j] == false &&        // 대각선 / 에 아직 배치 X
                    flag_c[i-j+7] == false) {      // 대각선 \ 에 아직 배치 X
                pos[i] = j; // 퀸을 j행에 배치
                if (i == 7) // 모든 열에 배치했다면
                    print();
                else {
                    flag_a[j] = flag_b[i + j] = flag_c[i-j+7] = true;
                    set(i+1);
                    flag_a[j] = flag_b[i + j] = flag_c[i-j+7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);             // 0열에 퀸을 배치합니다.
    }
}
