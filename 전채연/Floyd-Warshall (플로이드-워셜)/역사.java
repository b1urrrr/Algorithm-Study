/*
    백준 1613번 : 역사
    - 문제 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 역사 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사건의 개수 n 입력
        int k = Integer.parseInt(st.nextToken()); // 사건의 전후 관계 개수 k 입력
       
        // 최단 거리 테이블 초기화
        int[][][] spt = new int[n + 1][n + 1][2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Arrays.fill(spt[i][j], INF);
            }
            spt[i][i][0] = 0;
            spt[i][i][1] = 0;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 전에 일어난 사건 입력
            int b = Integer.parseInt(st.nextToken()); // 후에 일어난 사건 입력
            spt[a][b][0] = 1;
            spt[b][a][1] = 1;
        }

        // 플로이드 워셜 수행
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    spt[a][b][0] = Math.min(spt[a][b][0], spt[a][i][0] + spt[i][b][0]);
                    spt[a][b][1] = Math.min(spt[a][b][1], spt[a][i][1] + spt[i][b][1]);
                }
            }
        }

        int s = Integer.parseInt(br.readLine()); // 사건의 전후 관계를 알고 싶은 사건 쌍의 수 s 입력

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 첫 번째 사건 입력
            int b = Integer.parseInt(st.nextToken()); // 두 번째 사건 입력

            // 앞에 있는 번호의 사건이 먼저 일어난 경우
            if (spt[a][b][0] < INF) {
                bw.write(-1 + "\n");
                continue;
            }
            // 뒤에 있는 번호의 사건이 먼저 일어난 경우
            if (spt[a][b][1] < INF) {
                bw.write(1 + "\n");
                continue;
            }
            // 유추할 수 없는 경우
            bw.write(0 + "\n");
        }

        bw.flush();
    }
}
