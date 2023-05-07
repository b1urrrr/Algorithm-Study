/*
    백준 21940번 : 가운데에서 만나기
    - 문제 유형 : 그래프 이론, 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 가운데에서_만나기 {
    static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수 M 입력
        int[][] spt = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(spt[i], INF);
            spt[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 도시 A의 번호 입력
            int B = Integer.parseInt(st.nextToken()); // 도시 B의 번호 입력
            int T = Integer.parseInt(st.nextToken()); // 도시 A에서 도시 B로 이동하는 데 걸리는 시간 T 입력
            spt[A][B] = Math.min(spt[A][B], T);
        }

        for (int i = 1 ; i <= N; i ++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        int K = Integer.parseInt(br.readLine()); // 준형이와 친구들의 총 인원 K 입력
        int[] friends = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            friends[k] = Integer.parseInt(st.nextToken()); // 준형이와 친구들이 살고 있는 도시의 번호 입력
        }

        StringBuilder sb = new StringBuilder();
        int min = INF;
        for (int t = 1; t <= N; t++) {
            int max = 0;
            for (int f = 0; f < K; f++) {
                int distance = spt[friends[f]][t] + spt[t][friends[f]];
                if (distance >= INF) continue;
                max = Math.max(max, distance);
            }
            if (min == max) {
                sb.append(t + " ");
                continue;
            }
            if (min > max) {
                min = max;
                sb = new StringBuilder();
                sb.append(t + " ");
            }
        }

        // 조건을 만족하는 도시 X의 번호 오름차순 출력
        System.out.println(sb);
    }
}
