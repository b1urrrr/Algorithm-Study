/*
    백준 1507번 : 궁금한 민호
    - 문제 유형 : 그래프 이론, 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 궁금한_민호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 개수 N 입력
        int[][] spt = new int[N][N];
        int[][] length = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                length[i][j] = spt[i][j] = Integer.parseInt(st.nextToken()); // 각각의 도시 사이에 이동하는데 필요한 시간 입력
            }
        }

        for (int i = 0; i < N; i++) {
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (spt[a][i] == 0 || spt[i][b] == 0) continue;
                    
                    // 잘못된 입력인 경우
                    if (spt[a][i] + spt[i][b] < spt[a][b]) {
                        System.out.println(-1);
                        return;
                    }

                    if (spt[a][i] + spt[i][b] == spt[a][b]) {
                        length[a][b] = length[b][a] = 0;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                sum += length[i][j];
            }
        }

        // 도로 개수가 최소일 때, 모든 도로의 시간의 합 출력
        System.out.println(sum);
    }
}
