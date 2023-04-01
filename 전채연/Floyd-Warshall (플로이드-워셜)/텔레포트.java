/*
    백준 16958번 : 텔레포트
    - 문제 유형 : 그래프 이론, 브루트포스 알고리즘, 기하학, 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 텔레포트 {
    static class City {
        boolean speical;
        int r;
        int c;

        City(int s, int r, int c) {
            this.speical = s == 1;
            this.r = r;
            this.c = c;
        }

        /** 도시 이동 시간 반환 */
        int getTime(City other) {
            return Math.abs(this.r - other.r) + Math.abs(this.c - other.c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 수 N 입력
        int T = Integer.parseInt(st.nextToken()); // 텔레포트 하는 데 걸리는 시간 T 입력
        int[][] spt = new int[N + 1][N + 1];

        City[] cities = new City[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 특별한 도시 여부 s 입력 (1: 특별함, 2: 특별하지 않음) 
            int x = Integer.parseInt(st.nextToken()); // 도시의 x 좌표 입력
            int y = Integer.parseInt(st.nextToken()); // 도시의 y 좌표 입력

            cities[i] = new City(s, x, y);
        }

        // 최소 거리 테이블 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                spt[i][j] = cities[i].getTime(cities[j]);
                if (cities[i].speical && cities[j].speical) spt[i][j] = Math.min(spt[i][j], T);
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

        int M = Integer.parseInt(br.readLine()); // 두 도시의 쌍의 개수 M 입력

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 출발 도시 A 입력
            int B = Integer.parseInt(st.nextToken()); // 도착 도시 B 입력

            // A에서 B에 가는 최소 이동 시간 출력
            bw.write(spt[A][B] + "\n");
        }

        bw.flush();
    }
}
