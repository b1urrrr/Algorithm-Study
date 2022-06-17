/*
 * @author Minyeong Park
 * @date 2022.06.17.
 * 정수 삼각형 (다른 코드 공부)
 * 출처 : https://st-lab.tistory.com/131
 * 문제 링크 : https://www.acmicpc.net/problem/1932
 */

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] triangle;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        dp = new Integer[n][n];
        triangle[0][0] = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 마지막 행의 값들을 dp의 마지막 행에도 똑같이 복사
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        System.out.println(find(0,0));
    }

    static int find(int depth, int idx) {
        // 만약 맨 밑의 행에 도달하면 해당 인덱스를 반환한다.
        if (depth == n - 1)
            return dp[depth][idx];

        // 만약 아직 탐색하지 않은 위치라면 다음 행의 양쪽 열 중 최댓값을 구함
        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + triangle[depth][idx];
        }
        return dp[depth][idx];
    }
}