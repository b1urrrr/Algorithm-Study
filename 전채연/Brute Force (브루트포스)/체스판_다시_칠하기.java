/*
    백준 1018번 : 체스판 다시 칠하기
    - 문제 유형 : 브루트포스 알고리즘
*/

import java.io.*;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기 {
    // 다시 칠해야하는 정사각형의 개수 반환 메서드
    static int repaint(char[][] board, int startR, int startC) {
        char first = board[startR][startC]; // 시작 문자를 'W'로 초기화
        char second = (first == 'W') ? 'B' : 'W';
        int count = 0; // 칠하는 횟수
        for (int i = startR; i < startR + 8; i++) {
            int order = 0;
            for (int j = startC; j < startC + 8; j++) {
                char compare = (order++ % 2 == 0) ? first : second;
                // 정사각형을 칠해야 하는 경우
                if (board[i][j] != compare) count++;
            }
            first = (first == 'W') ? 'B' : 'W';
            second = (second == 'W') ? 'B' : 'W';
        }
        count = (count < 64 - count) ? count : 64 - count; // 최솟값 저장
        return count;
    }
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int cols = Integer.parseInt(st.nextToken()); // 행의 개수 저장
        int rows = Integer.parseInt(st.nextToken()); // 열의 개수 저장
        char[][] board = new char[cols][rows]; // 보드판

        for (int i = 0; i < cols; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            String col = st.nextToken(); 
            for (int j = 0; j < rows; j++) {
                board[i][j] = col.charAt(j); // 보드판 정사각형의 색상 저장
            }
        }

        int min = 65;
        int result;
        for (int i = 0; i <= cols - 8; i++) {
            for (int j = 0; j <= rows - 8; j++) {
                result = repaint(board, i, j); // i열 j행에서 시작하는 8X8 보드판의 결과
                min = (min < result) ? min : result; // 최솟값 저장
            }
        }

        // 최솟값 출력
        System.out.println(min);
    }
}