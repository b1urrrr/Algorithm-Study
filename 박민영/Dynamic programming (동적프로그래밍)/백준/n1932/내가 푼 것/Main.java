/*
 * @author Minyeong Park
 * @date 2022.06.17.
 * 정수 삼각형
 * 문제 링크 : https://www.acmicpc.net/problem/1932
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        triangle[0][0] = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if (j == n - 1) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < triangle[n-1][i])
                max = triangle[n-1][i];
        }
        System.out.println(max);
    }
}