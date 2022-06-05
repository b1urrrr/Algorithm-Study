// chap04 (2) 실전 문제 : 왕실의 나이트 (내가 푼 것)
// 풀이 시간 20분 안에 못 풀었음..
// 개선할 사항 : 1) col의 문자 값을 숫자로 변환할 때, 그냥 'a'를 빼는 식으로 구하면 더 간단하게 변환할 수 있음!
//             2) 이동하는 규칙들을 미리 정의해두고, 그 정의에 따라서 이동해보면서 가능한지를 구하면 더 간단하게 구할 수 있음!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n4_3_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String location = br.readLine();
        int[][] arr = new int[8][8];
        int row, col = -1;
        switch (location.charAt(0)) {
            case 'a' :
                col = 0;
                break;
            case 'b' :
                col = 1;
                break;
            case 'c' :
                col = 2;
                break;
            case 'd' :
                col = 3;
                break;
            case 'e' :
                col = 4;
                break;
            case 'f' :
                col = 5;
                break;
            case 'g' :
                col = 6;
                break;
            case 'h' :
                col = 7;
                break;
        }
        row = Integer.parseInt(location.charAt(1)+"") - 1;

        int count = 0;

        int temp_row, temp_col;

        // 오른쪽으로 수평2 + 수직1 방식
        temp_col = col + 2;
        if (temp_col < 8) {
            if (row > 0 && row < 8) {
                count += 2;
            }
            else if (row == 0 || row == 8) {
                count += 1;
            }

        }

        // 왼쪽으로 수평2 + 수직1 방식
        temp_col = col - 2;
        if (temp_col >= 0) {
            if (row > 0 && row < 8) {
                count += 2;
            }
            else if (row == 0 || row == 8) {
                count += 1;
            }

        }

        // 위쪽으로 수직2 + 수평1 방식
        temp_row = row - 2;
        if (temp_row >= 0) {
            if (col > 0 && col < 8) {
                count += 2;
            }

            else if (col == 0 || col == 8) {
                count += 1;
            }

        }

        // 아래쪽으로 수직2 + 수평1 방식
        temp_row = row + 2;
        if (temp_row < 8) {
            if (col > 0 && col < 8) {
                count += 2;
            }
            else if (col == 0 || col == 8) {
                count += 1;
            }

        }
        System.out.println(count);
    }
}
