package chap16;

import java.io.*;
import java.util.*;

public class Question16_32 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 삼각형의 크기 n 입력
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken()); // 삼각형을 이루는 정수값 입력
            }
        }

        int max = triangle[0][0];

        // j열 i행까지의 경로에 있는 수의 합 최대값 구하기
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 첫 번째 정수인 경우
                if (j == 0) triangle[i][j] += triangle[i - 1][j];
                // 마지막 정수인 경우
                else if (j == i) triangle[i][j] += triangle[i - 1][j - 1];
                // 중간에 위치한 정수인 경우
                else triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);

                // 마지막 행인 경우 최대값 갱신
                if (i == n - 1) max = Math.max(max, triangle[i][j]);
            }
        }

        // 합이 최대가 되는 경로에 있는 수의 합 출력
        System.out.println(max);
    }
}
