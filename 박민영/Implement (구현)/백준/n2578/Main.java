/*
 * @author Minyeong Park
 * @date 2022.09.25.
 * 빙고
 * 문제 링크 : https://www.acmicpc.net/problem/2578
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] my = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                my[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        Loop1:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                count++;
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if (num == my[x][y]) {
                            my[x][y] = -1;
                        }
                    }
                }

                int line_count = 0;
                for (int x = 0; x < 5; x++) {
                    boolean flag = true;
                    for (int y = 0; y < 5; y++) {
                        if (my[x][y] != -1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        line_count++;
                    }
                }
                for (int x = 0; x < 5; x++) {
                    boolean flag = true;
                    for (int y = 0; y < 5; y++) {
                        if (my[y][x] != -1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        line_count++;
                    }
                }
                boolean flag_1 = true;
                for (int x = 0; x < 5; x++) {
                    if (my[x][x] != -1) {
                        flag_1 = false;
                        break;
                    }
                }
                if (flag_1) {
                    line_count++;
                }

                boolean flag_2 = true;
                for (int x = 0; x < 5; x++) {
                    if (my[4-x][x] != -1) {
                        flag_2 = false;
                        break;
                    }
                }
                if (flag_2) {
                    line_count++;
                }

                if (line_count >= 3) {
                    break Loop1;
                }
            }
        }

        System.out.println(count);
    }
}