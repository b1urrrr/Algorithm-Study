/*
 * @author Minyeong Park
 * @date 2022.09.01.
 * 성 지키기
 * 원리 참고 : https://zzang9ha.tistory.com/122
 * 문제 링크 : https://www.acmicpc.net/problem/1236
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        String input_str;
        for (int i = 0; i < n; i++) {
            input_str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input_str.charAt(j);
            }
        }

        int row_count = 0;
        int col_count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != '.') {
                    break;
                }
                if (j == m - 1) {
                    row_count++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j][i] != '.') {
                    break;
                }
                if (j == n - 1) {
                    col_count++;
                }
            }
        }

        // 행, 열 중 더 많은 경비원 추가
        System.out.println(Math.max(row_count, col_count));
    }
}