/*
 * @author Minyeong Park
 * @date 2022.09.02.
 * 임시 반장 정하기
 * 문제 링크 : https://www.acmicpc.net/problem/1268
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] table = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] count = new int[n];
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) { // 몇 번 학생에 대해 파악하는지
            Arrays.fill(flag, false);
            for (int j = 0; j < 5; j++) { // i번째 학생의 j학년 때를 비교
                for (int k = 0; k < n; k++) { // 나머지 학생들과 반을 비교
                    if (k == i) {
                        continue;
                    } else if (table[k][j] == table[i][j] && !flag[k]) {
                        count[i]++;
                        flag[k] = true;
                    }
                }
            }
        }

        int master = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[master]) {
                master = i;
            }
        }
        System.out.println(master+1);
    }
}