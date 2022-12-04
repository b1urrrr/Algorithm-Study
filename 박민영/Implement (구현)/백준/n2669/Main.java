/*
 * @author Minyeong Park
 * @date 2022.12.04.
 * 직사각형 네개의 합집합의 면적 구하기
 * 문제 링크 : https://www.acmicpc.net/problem/2669
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[101][101];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int l_x = Integer.parseInt(st.nextToken());
            int l_y = Integer.parseInt(st.nextToken());
            int r_x = Integer.parseInt(st.nextToken());
            int r_y = Integer.parseInt(st.nextToken());

            for (int x = l_x; x < r_x; x++) {
                for (int y = l_y; y < r_y; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}