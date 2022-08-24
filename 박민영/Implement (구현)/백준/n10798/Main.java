/*
 * @author Minyeong Park
 * @date 2022.08.21.
 * 세로읽기
 * 참고 : https://cheerant.tistory.com/44 (2차원 배열 특정 값으로 채우기)
 * 문제 링크 : https://www.acmicpc.net/problem/10798
 */


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str_arr = new String[5];
        int max_length = 0;
        for (int i = 0 ; i < 5; i++) {
            str_arr[i] = sc.nextLine();
            if (str_arr[i].length() > max_length) {
                max_length = str_arr[i].length();
            }
        }

        char[][] ch_arr = new char[5][max_length];
        for (char a[] : ch_arr) {
            Arrays.fill(a, ' ');
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < str_arr[i].length(); j++) {
                ch_arr[i][j] = str_arr[i].charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max_length; i++) {
            for (int j = 0; j < 5; j++) {
                if (ch_arr[j][i] != ' ')
                    sb.append(ch_arr[j][i]);
            }
        }
        System.out.println(sb);

    }
}