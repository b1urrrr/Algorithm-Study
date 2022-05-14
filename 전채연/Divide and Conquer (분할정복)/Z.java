/*
    백준 1074번 : Z
    - 문제 유형 : 분할 정복, 재귀
*/

import java.io.*;
import java.util.StringTokenizer;

public class Z {
    static int count = 0;

    // r행 r열이 몇 번째 사분면에 속하는지 확인하는 재귀 함수
    static void searchZ(int size, int r, int c) {
        // 끝까지 탐색한 경우 함수 종료
        if (size == 1) {
            return;
        }

        if (r < size / 2 && c < size / 2) {           // 1사분면
            searchZ(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {   // 2사분면
            count += size * size / 4;
            searchZ(size / 2, r, c - size / 2);
        } else if (r >= size / 2 && c < size / 2) {   // 3사분면
            count += 2 * (size * size / 4);
            searchZ(size / 2, r - size / 2, c);
        } else {                                      // 4사분면
            count += 3 * (size * size / 4);
            searchZ(size / 2, r - size / 2, c - size / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // N 입력
        int row = Integer.parseInt(st.nextToken()); // 행 입력
        int col = Integer.parseInt(st.nextToken()); // 열 입력
        int size = (int) Math.pow(2, n);

        searchZ(size, row, col);
        System.out.println(count); // 결과 출력
    }
}