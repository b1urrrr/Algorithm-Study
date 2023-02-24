/*
    백준 1389번 : 케빈 베이컨의 6단계 법칙
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 플로이드-워셜
    - 풀이 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 케빈_베이컨의_6단계_법칙 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 유저의 수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수 M 입력
        int[][] spt = new int[N + 1][N + 1];

        // 최단 거리 테이블 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(spt[i], INF);
            spt[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 친구A 입력
            int B = Integer.parseInt(st.nextToken()); // 친구B 입력
            spt[A][B] = 1;
            spt[B][A] = 1;
        }

        // 플로이드 워셜 수행
        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        // 케빈 베이컨 수 계산
        int result = INF;
        int num = INF;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) sum += spt[i][j];
            if (sum < result) {
                result = sum;
                num = i;
            }
        }

        // 유저 중에서 케빈 베이컨의 수가 가장 작은 사람 출력
        System.out.println(num);
    }
}
