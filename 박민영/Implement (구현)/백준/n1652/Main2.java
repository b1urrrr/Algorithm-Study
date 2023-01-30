/*
 * @author Minyeong Park
 * @date 2023.01.29.
 * 누울 자리를 찾아라 (다른 풀이 공부)
 * 출처 : https://yenny-zzang.tistory.com/65
 * 문제 링크 : https://www.acmicpc.net/problem/1652
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int row_count = 0;
        int col_count = 0;

        // 가로, 세로 방향으로 누울 수 있는지 여부
        for (int i = 0; i < n; i++) {
            int check_h = 0, check_v = 0;
            for (int j = 0; j < n; j++) {
                // 가로 체크
                if (map[i][j] == '.') check_h++;
                if (map[i][j] == 'X' || (j == n-1)) {
                    if (check_h >= 2) row_count++;
                    check_h = 0;
                }

                // 세로 체크
                if (map[j][i] == '.') check_v++;
                if (map[j][i] == 'X' || (j == n-1)) {
                    if (check_v >= 2) col_count++;
                    check_v = 0;
                }
            }
        }

        System.out.println(row_count + " " + col_count);
    }
}