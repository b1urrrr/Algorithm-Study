/*
 * @author Minyeong Park
 * @date 2022.09.17.
 * 마인크래프트
 * 참고 : 문제 접근 방식 관련 - https://wonit.tistory.com/540,
 *       반례 모음 - https://www.acmicpc.net/board/view/86190
 *       min_time 범위 관련 - https://www.acmicpc.net/board/view/94100
 * 문제 링크 : https://www.acmicpc.net/problem/18111
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer n = Integer.parseInt(st.nextToken());
        Integer m = Integer.parseInt(st.nextToken());
        Integer b = Integer.parseInt(st.nextToken());
        int[][] ground = new int[n][m];
        int min = 256;
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if (ground[i][j] < min) {
                    min = ground[i][j];
                }
                if (ground[i][j] > max) {
                    max = ground[i][j];
                }
            }
        }

        int min_time = 1000000000;
        int max_height = 0;
        Loop1:
        for (int height = min; height <= max; height++) {
            int del_count = 0;
            int ins_count = 0;
            int temp_b = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ground[i][j] < height) {
                        ins_count += height - ground[i][j];
                        temp_b -= height - ground[i][j];
                    } else if (ground[i][j] > height) {
                        del_count += ground[i][j] - height;
                        temp_b += ground[i][j] - height;
                    }
                }
            }
            if (temp_b < 0) {
                continue Loop1;
            }
            int time = del_count * 2 + ins_count;
            if (time <= min_time && height >= max_height) {
                min_time = time;
                max_height = height;
            }
        }

        System.out.println(min_time + " " + max_height);
    }
}