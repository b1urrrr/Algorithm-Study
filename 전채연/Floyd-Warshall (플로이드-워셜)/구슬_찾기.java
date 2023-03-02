/*
    백준 2617번 : 구슬 찾기
    - 문제 유형 : 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 플로이드-워셜
    - 풀이 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 구슬_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 구슬의 개수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 저울에 올려 본 쌍의 개수 M 입력
        boolean[][] spt = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken()); // 무거운 구슬 번호 입력
            int light = Integer.parseInt(st.nextToken()); // 가벼운 구슬 번호 입력
            spt[heavy][light] = true;
        }

        // 플로이드 워셜 수행
        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    spt[a][b] = spt[a][b] || (spt[a][i] && spt[i][b]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            int heavyCount = 0;
            int lightCount = 0;
            for (int j = 1; j <= N; j++) {
                if (spt[i][j]) heavyCount++;
                if (spt[j][i]) lightCount++;
            }
            if (heavyCount > N / 2 || lightCount > N / 2) result++;
        }

        // 무게가 중간이 절대로 될 수 없는 구슬의 수 출력
        System.out.println(result);
    }
}
