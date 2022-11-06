/*
 * @author Minyeong Park
 * @date 2022.11.06.
 * 최댓값
 * 문제 링크 : https://www.acmicpc.net/problem/2566
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[9][9];
        int max = 0;
        int max_row = 0;
        int max_col = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= max) {
                    max = arr[i][j];
                    max_row = i+1;
                    max_col = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(max_row + " " + max_col);
    }
}