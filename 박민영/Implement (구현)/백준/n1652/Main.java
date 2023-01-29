/*
 * @author Minyeong Park
 * @date 2023.01.29.
 * 누울 자리를 찾아라
 * 문제 링크 : https://www.acmicpc.net/problem/1652
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int row_count = 0;
        int col_count = 0;

        // 가로로 누울 수 있는 자리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') {
                    if (j + 1 >= n) {
                        continue;
                    }
                    if (map[i][j+1] == '.') {
                        row_count++;
                        for (; j < n; j++) {
                            if (map[i][j] != '.') {
                                break;
                            }
                        }
                    }
                }
            }
        }

        // 세로로 누울 수 있는 자리
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (map[i][j] == '.') {
                    if (i + 1 >= n) {
                        continue;
                    }
                    if (map[i+1][j] == '.') {
                        col_count++;
                        for (; i < n; i++) {
                            if (map[i][j] != '.') {
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(row_count + " " + col_count);
    }
}