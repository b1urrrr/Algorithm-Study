/*
 * @author Minyeong Park
 * @date 2022.09.28.
 * 파스칼의 삼각형
 * 문제 링크 : https://www.acmicpc.net/problem/16395
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[30][30];
        for (int i = 0; i < 30; i++) {
            arr[i][0] = 1; // 한 행에서 맨 처음 부분
            arr[i][i] = 1; // 한 행에서 맨 마지막 부분
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }

        System.out.println(arr[n-1][k-1]);
    }
}