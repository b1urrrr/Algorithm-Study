/*
    백준 10159번 : 저울
    - 문제 유형 : 그래프 이론, 그래프 탐색, 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 저울 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 물건의 개수 N 입력
        int M = Integer.parseInt(br.readLine()); // 측정된 물건 쌍의 개수 M 입력
        boolean[][] spt = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) spt[i][i] = true;

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int light = Integer.parseInt(st.nextToken()); // 가벼운 물건 입력
            int heavy = Integer.parseInt(st.nextToken()); // 무거운 물건 입력
            spt[light][heavy] = true;
        }

        // 플로이드 워셜 수행
        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    spt[a][b] = spt[a][b] || (spt[a][i] && spt[i][b]);
                }
            }
        }

        // i 번째 줄에 물건 i 와 비교 결과를 알 수 없는 물건의 개수 출력
        for (int i = 1; i <= N; i++) {
            int sum = N;
            for (int j = 1; j <= N; j++) if (spt[i][j] || spt[j][i]) sum--;
            bw.write(sum + "\n");
        }

        bw.flush();
    }
}
