/*
    백준 1504번 : 특정한 최단 경로
    - 문제 유형 : 그래프 이론
    - 풀이 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 특정한_최단_경로 {
    static final int INF = (int) 7e8;
    static int[][] spt; // 최단 거리 테이블 (shortest path table)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수 N 입력
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수 E 입력
        spt = new int[N + 1][N + 1];

        // 최단 거리 테이블 무한으로 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(spt[i], INF);
        }

        // 시작 정점과 도착 정점이 동일하면 spt 0으로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) spt[i][j] = 0;
            }
        }

        // 간선의 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 양 끝 정점의 번호 a 입력
            int b = Integer.parseInt(st.nextToken()); // 양 끝 정점의 번호 b 입력
            int c = Integer.parseInt(st.nextToken()); // 정점 간의 거리 c 입력
            if (c < spt[a][b]) {
                spt[a][b] = c;
                spt[b][a] = c;
            }
        }

        // 플로이드 워셜 실행
        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        // 반드시 거쳐야 하는 두 개의 정점 번호 입력
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 두 개의 정점을 지나는 최단 경로의 길이 출력
        int path1 = spt[1][v1] + spt[v1][v2] + spt[v2][N];
        int path2 = spt[1][v2] + spt[v2][v1] + spt[v1][N];
        // 두 경로 모두 존재하지 않는 경우
        if (path1 >= INF && path2 >= INF) System.out.println(-1);
        // path1이 존재하지 않는 경우
        else if (path1 >= INF && path2 < INF) System.out.println(path2);
        // path2가 존재하지 않는 경우
        else if (path1 < INF && path2 >= INF) System.out.println(path1);
        // 두 경로 모두 존재하는 경우
        else System.out.println(Math.min(path1, path2));
    }
}
