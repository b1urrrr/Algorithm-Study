/*
 * @author Minyeong Park
 * @date 2022.06.09.
 * RGB거리 (반복문)
 * 원리 참고 : https://st-lab.tistory.com/128
 * 문제 링크 : https://www.acmicpc.net/problem/1149
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) { // 2번째 줄 집부터 시작
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
        }

        int result = Math.min(Math.min(cost[n-1][0], cost[n-1][1]), cost[n-1][2]);
        System.out.println(result);
    }
}