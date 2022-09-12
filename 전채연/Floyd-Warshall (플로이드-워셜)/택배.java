/*
    백준 1719번 : 택배
    - 문제 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 택배 {
    static final int INF = (int) 1e9;
    static int[][] spt; // 최단 경로 테이블
    static String[][] drop; // 가장 먼저 거쳐야 하는 집하장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집하장의 개수 n 입력
        int m = Integer.parseInt(st.nextToken()); // 집하장간 경로의 개수 m 입력
        spt = new int[n + 1][n + 1];
        drop = new String[n + 1][n + 1];

        // 최단 경로 테이블, 집하장 배열 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(spt[i], INF);
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    spt[i][j] = 0;
                    drop[i][j] = "-";
                }
            }
        }

        // 집하장간 경로 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 집하장1 입력
            int b = Integer.parseInt(st.nextToken()); // 집하장2 입력
            int time = Integer.parseInt(st.nextToken()); // 집하장 사이를 오가는 데 걸리는 시간 입력
            if (time < spt[a][b]) {
                spt[a][b] = time;
                drop[a][b] = String.valueOf(b);
                spt[b][a] = time;
                drop[b][a] = String.valueOf(a);
            }
        }

        // 플로이드 워셜 실행
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (spt[a][i] + spt[i][b] < spt[a][b]) {
                        spt[a][b] = spt[a][i] + spt[i][b];
                        drop[a][b] = drop[a][i];
                    }
                }
            }
        }

        // 최단경로로 화물을 이동시키기 위해 가장 먼저 거쳐야 하는 집하장 경로표 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(drop[i][j] + " ");
            }
            System.out.println();
        }
    }
}