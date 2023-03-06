/*
    백준 2660번 : 회장뽑기
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 플로이드-워셜
    - 풀이 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 회장뽑기 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int members = Integer.parseInt(br.readLine()); // 회원의 수 입력
        int[][] spt = new int[members + 1][members + 1];
        for (int i = 1; i <= members; i++) {
            Arrays.fill(spt[i], INF);
            spt[i][i] = 0;
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken()); // 친구1 입력
            int f2 = Integer.parseInt(st.nextToken()); // 친구2 입력
            if (f1 == -1 && f2 == -1) break;

            spt[f1][f2] = 1;
            spt[f2][f1] = 1;
        }

        // 플로이드 워셜 수행
        for (int i = 1; i <= members; i++) {
            for (int a = 1; a <= members; a++) {
                for (int b = 1; b <= members; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        // 점수 합산
        int min = INF;
        int count = 0;
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= members; i++) {
            int score = 0;
            for (int j = 1; j <= members; j++) score = Math.max(score, spt[i][j]);
            // 회장 후보 초기화
            if (score < min) {
                min = score;
                count = 0;
                candidates = new ArrayList<>();
            }
            if (score <= min) {
                candidates.add(i);
                count++;
            }
        }

        // 회장 후보의 점수와 후보의 수 출력
        System.out.printf("%d %d\n", min, count);
        // 회장 후보 오름차순 출력
        for (int i = 0; i < candidates.size(); i++) {
            System.out.print(candidates.get(i) + " ");
        }
        System.out.println();
    }
}
