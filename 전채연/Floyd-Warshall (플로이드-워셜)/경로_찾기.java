/*
    백준 11403번 : 경로 찾기
    - 문제 유형 : 그래프 이론, 그래프 탐색, 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 경로_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 정점의 개수 N 입력
        int spt[][] = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                spt[i][j] = Integer.parseInt(st.nextToken()); // 정점i에서 정점j로 가는 경로 존재 여부 입력 (1: 있음, 0: 없음)
            }
        }

        // 플로이드 워셜 수행
        for (int i = 0; i < N; i++) {
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    spt[a][b] = Math.max(spt[a][b], spt[a][i] & spt[i][b]);
                }
            }
        }

        // 정점 i에서 j로 가는 경로 존재 여부 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(spt[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
