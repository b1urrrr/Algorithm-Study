/*
 * @author Minyeong Park
 * @date 2022.10.29.
 * 숫자 정사각형
 * 문제 링크 : https://www.acmicpc.net/problem/1051
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int max_size = 1;
        int limit = Math.min(row, col);
        for (int size = 2; size <= limit; size++) {
            for (int i = 0; i <= row - size; i++) {
                for (int j = 0; j <= col - size; j++) {
                    if (arr[i][j] == arr[i][j-1+size] && arr[i-1+size][j] == arr[i-1+size][j-1+size] && arr[i][j] == arr[i-1+size][j]) {
                        max_size = size * size;
                    }
                }
            }
        }

        System.out.println(max_size);
    }
}