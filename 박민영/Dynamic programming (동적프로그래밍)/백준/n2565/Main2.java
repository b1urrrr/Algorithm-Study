/*
 * @author Minyeong Park
 * @date 2022.06.26.
 * 전깃줄 (Bottom-up)
 * 너무 막혀서 원리 참고 : https://st-lab.tistory.com/138, https://yabmoons.tistory.com/572(원리 이해 잘 되는 글)
 * 문제 링크 : https://www.acmicpc.net/problem/2565
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] lines;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        lines = new int[n][2];
        dp = new Integer[n]; // 방문 여부를 판단
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        // A 전봇대 기준으로 정렬
        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;
        // i번째 A 전봇대를 기준으로 연결 가능한 개수 탐색 및 최댓값 찾기
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (lines[i][1] > lines[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        // 전선 개수 - 최댓값
        System.out.println(n - max);
    }
}