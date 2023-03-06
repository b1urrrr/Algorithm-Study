/*
    백준 11265번 : 끝나지 않는 파티
    - 문제 유형 : 그래프 이론, 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 끝나지_않는_파티 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 파티장의 크기 N 입력
        int M = Integer.parseInt(st.nextToken()); // 서비스를 요청한 손님의 수 M 입력
        int[][] spt = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                spt[i][j] = Integer.parseInt(st.nextToken()); // i번 파티장에서 j번 파티장으로 이동하는 시간
            }
        }

        // 플로이드 워셜 수행
        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 손님이 위치한 파티장의 번호 A 입력
            int B = Integer.parseInt(st.nextToken()); // 다음 파티가 열리는 파티장의 번호 B 입력
            int C = Integer.parseInt(st.nextToken()); // 지금으로부터 다음 파티가 열리는 데 걸리는 시간 C 입력

            // 시간 내 다른 파티장 도착 가능 여부 출력
            bw.write((spt[A][B] > C)? "Stay here\n" : "Enjoy other party\n");
        }

        bw.flush();
    }
}
