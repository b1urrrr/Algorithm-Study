/*
    백준 13424번 : 비밀 모임
    - 문제 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 비밀_모임 {
    static final int INF = 2001;
    static int[][] spt; // 최단 거리 테이블

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 T 입력

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 방의 개수 N 입력
            int M = Integer.parseInt(st.nextToken()); // 비밀통로의 개수 M 입력
            spt = new int[N + 1][N + 1];

            // 최단 거리 테이블 초기화
            for (int i = 1; i <= N; i++) {
                Arrays.fill(spt[i], INF);
                for (int j = 1; j <= N; j++) {
                    if (i == j) spt[i][j] = 0;
                }
            }

            // 비밀 통로의 정보 입력
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 비밀통로와 연결된 방1 a 입력
                int b = Integer.parseInt(st.nextToken()); // 비밀통로와 연결된 방2 b 입력
                int c = Integer.parseInt(st.nextToken()); // 비밀통로의 길이 c 입력
                spt[a][b] = c;
                spt[b][a] = c;
            }

            // 플로이드 워셜 실행 
            for (int i = 1; i <= N; i++) {
                for (int a = 1; a <= N; a++) {
                    for (int b = 1; b <= N; b++) {
                        spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                        spt[b][a] = Math.min(spt[b][a], spt[b][i] + spt[i][a]);
                    }
                }
            }

            int K = Integer.parseInt(br.readLine()); // 친구의 수 K 입력
            int[] friends = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                friends[i] = Integer.parseInt(st.nextToken()); // 친구가 위치한 방의 번호 입력  
            }

            // 친구들의 이동 거리 총합의 최소값 계산
            int result = -1;
            int min = (int) 1e6;
            for (int i = 1; i <= N; i++) { // i번 방에서 모이는 경우의 이동거리 총합 계산
                int count = 0;
                for (int j = 0; j < K; j++) {
                    count += spt[friends[j]][i];
                }
                if (count < min) {
                    min = count;
                    result = i;
                }
            }

            // 친구들의 이동 거리의 총합이 최소가 되도록 하는 모임 장소 출력
            bw.write(result + "\n");
        }
        bw.flush();
    }
}