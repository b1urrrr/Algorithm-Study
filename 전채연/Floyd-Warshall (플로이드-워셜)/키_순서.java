/*
    백준 2458번 : 키 순서
    - 문제 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 키_순서 {
    static final int INF = (int) 1e9;
    static int[][] small, tall; // 최단 거리 테이블

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생들의 수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 두 학생 키를 비교한 횟수 M 입력
        small = new int[N + 1][N + 1];
        tall = new int [N + 1][N + 1];

        // 최단 거리 테이블 초기화
        for (int i = 0; i <= N; i++) {
            Arrays.fill(small[i], INF);
            Arrays.fill(tall[i], INF);
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    small[i][j] = 0;
                    tall[i][j] = 0;
                }
            }
        }

        // 두 학생의 키를 비교한 결과 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 키가 작은 학생의 번호 a 입력
            int b = Integer.parseInt(st.nextToken()); // 키가 큰 학생의 번호 b 입력
            small[a][b] = 1;
            tall[b][a] = 1;
        }

        // 플로이드 워셜 실행
        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    small[a][b] = Math.min(small[a][b], small[a][i] + small[i][b]);
                    tall[a][b] = Math.min(tall[a][b], tall[a][i] + tall[i][b]);
                }
            }
        }

        // 자신이 키가 몇 번째인지 알 수 있는 학생의 수 계산
        int count = 0;
        I : for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (small[i][j] == INF && tall[i][j] == INF) continue I;
            }
            count++;
        }

        // 자신이 키가 몇 번째인지 알 수 있는 학생의 수 출력
        System.out.println(count);
    }
}
