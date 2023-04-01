/*
    백준 1956번 : 운동
    - 문제 유형 : 그래프 이론, 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 운동 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 마을의 개수 V 입력
        int E = Integer.parseInt(st.nextToken()); // 도로의 개수 E 입력
        int spt[][] = new int[V + 1][V + 1];
        
        // 최단 거리 테이블 초기화
        for (int i = 1; i <= V; i++) {
            Arrays.fill(spt[i], INF);
            spt[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 마을 a 입력
            int b = Integer.parseInt(st.nextToken()); // 마을 b 입력
            int c = Integer.parseInt(st.nextToken()); // 도로의 길이 c 입력
            spt[a][b] = c;
        }

        // 플로이드 워셜 수행
        for (int i = 1; i <= V; i++) {
            for (int a = 1; a <= V; a++) {
                for (int b = 1; b <= V; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        // 최소 사이클의 도로 길이의 합 출력
        int result = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) result = Math.min(result, spt[i][j] + spt[j][i]);
            }
        }
        System.out.println((result == INF)? -1 : result);
    }
}
