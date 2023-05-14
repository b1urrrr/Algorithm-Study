/*
    백준 1240번 : 노드사이의 거리
    - 문제 유형 : 그래프 이론, 그래프 탐색, 트리, 너비 우선 탐색, 깊이 우선 탐색
    - 풀이 유형 : 플로이드 워셜
*/

import java.io.*;
import java.util.*;

public class 노드사이의_거리 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드의 개수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 거리를 알고싶은 두 노드 쌍의 개수 M 입력

        int[][] spt = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(spt[i], INF);
            spt[i][i] = 0;
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            // 트리에 연결된 두 노드 입력
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 두 노드의 거리 입력
            int distance = Integer.parseInt(st.nextToken());
            spt[a][b] = Math.min(spt[a][b], distance);
            spt[b][a] = Math.min(spt[b][a], distance);
        }

        // 플로이드 워셜 수행
        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 거리를 알고 싶은 노드 쌍 입력
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(spt[a][b] + "\n");
        }
        bw.flush();
    }
}
