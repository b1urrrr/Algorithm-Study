/*
    백준 1238번 : 파티
    - 문제 유형 : 그래프 이론
    - 풀이 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 파티 {
    static final int INF = (int) 1e9;
    static int[][] spt; // 최단 거리 테이블 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 마을과 학생의 수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 단방향 도로의 수 M 입력
        int X = Integer.parseInt(st.nextToken()); // 파티를 벌이는 마을 X 입력
        spt = new int[N + 1][N + 1];

        // 최단 거리 테이블 무한으로 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(spt[i], INF);
        }

        // 시작 마을과 도착 마을이 동일한 경우 spt 0으로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) spt[i][j] = 0;
            }
        }

        // 도로의 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 도로의 시작점 입력
            int end = Integer.parseInt(st.nextToken()); // 도로의 끝점 입력
            int T = Integer.parseInt(st.nextToken()); // 도로를 지나는데 필요한 소요시간 입력
            spt[start][end] = Math.min(spt[start][end], T);
        }

        // 플로이드 워셜 실행
        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        // 가장 오래 걸리는 학생의 소요시간 계산
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int time = spt[i][X] + spt[X][i];
            // 경로가 존재하지 않는 경우 무시
            if (time >= INF) continue;
            max = Math.max(max, time);
        }

        // N명의 학생들 중 오고 가는데 가장 오래 걸리는 학생의 소요시간 출력
        System.out.println(max);
    }
}