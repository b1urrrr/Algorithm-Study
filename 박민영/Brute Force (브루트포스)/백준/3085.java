/*
 * @author Minyeong Park
 * @date 2023.04.08.
 * 사탕 게임
 * 문제 링크 : https://www.acmicpc.net/problem/3085
 */


import java.io.*;

public class Main {
    static int n;
    static int max = 0;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 행 : 가로로 돌면서 파악
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                char swap = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = swap;

                check(); // max 값 찾기

                // 원상 복구
                swap = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = swap;
            }
        }

        // 열 : 세로로 돌면서 파악
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                char swap = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = swap;

                check(); // max 값 찾기

                // 원상 복구
                swap = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = swap;
            }
        }

        System.out.println(max);
    }

    static int check() {
        // 가로
        for (int i = 0; i < n; i++) {
            int temp_cnt = 1; // 한 행마다 파악하므로 새로운 행을 돌면 temp_cnt값을 1로 초기화해주어야 함
            for (int j = 0; j < n-1; j++) {
                if (map[i][j] == map[i][j+1]) {
                    temp_cnt++;
                }
                else {
                    temp_cnt = 1;
                }
                max = Math.max(max, temp_cnt);
            }
        }

        // 세로
        for (int i = 0; i < n; i++) {
            int temp_cnt = 1;
            for (int j = 0; j < n-1; j++) {
                if (map[j][i] == map[j+1][i]) {
                    temp_cnt++;
                }
                else {
                    temp_cnt = 1;
                }
                max = Math.max(max, temp_cnt);
            }
        }
        return max;
    }
}