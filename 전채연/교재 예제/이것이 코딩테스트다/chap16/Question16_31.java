package chap16;

import java.io.*;
import java.util.*;

public class Question16_31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 T 입력
        
        // 테스트 케이스만큼 반복
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 금광의 세로 길이 입력
            int m = Integer.parseInt(st.nextToken()); // 금광의 가로 길이 입력
            int[][] mine = new int[n][m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mine[i][j] = Integer.parseInt(st.nextToken()); // 매장된 금의 개수 입력
                }
            }

            int max = 0;

            // i열 j행에서 채굴자가 얻을 수 있는 금의 최대 크기 구하기
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 첫 번째 열인 경우
                    if (j == 0) mine[j][i] += Math.max(mine[j][i - 1], mine[j + 1][i - 1]);
                    // 마지막 열인 경우
                    else if (j == n - 1) mine[j][i] += Math.max(mine[j - 1][i - 1], mine[j][i - 1]);
                    // 중간 열인 경우
                    else mine[j][i] += Math.max(Math.max(mine[j - 1][i - 1], mine[j][i - 1]), mine[j + 1][i - 1]);

                    // 마지막 열인 경우 최대값 갱신
                    if (i == m - 1) max = Math.max(max, mine[j][i]);
                }
            }

            // 채굴자가 얻을 수 있는 금의 최대 크기 출력
            System.out.println(max);
        }
    }
}