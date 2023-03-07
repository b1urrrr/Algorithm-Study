/*
    백준 21278번 : 호석이 두 마리 치킨
    - 문제 유형 : 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색, 플로이드-워셜
    - 풀이 유형 : 플로이드-워셜, 브루트포스
*/

import java.io.*;
import java.util.*;

public class 호석이_두_마리_치킨 {
    static final int INF = (int) 1e9;

    static class Building implements Comparable<Building> {
        int[] index;
        int time;

        Building(int index1, int index2, int time) {
            this.index = new int[2];
            index[0] = Math.min(index1, index2);
            index[1] = Math.max(index1, index2);
            this.time = time;
        }

        @Override
        public int compareTo(Building other) {
            return this.time - other.time; 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 건물의 개수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수 M 입력
        int[][] spt = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                spt[i][j] = INF;
            }
            spt[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int Ai = Integer.parseInt(st.nextToken()); // 도로에 해당하는 건물 Ai 입력
            int Bi = Integer.parseInt(st.nextToken()); // 도로에 해당하는 건물 Bi 입력
            spt[Ai][Bi] = 1;
            spt[Bi][Ai] = 1;
        }

        // 플로이드 워셜 수행
        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        // 왕복 시간이 최소인 건물 2개 완전 탐색
        List<Building> buildings = new ArrayList<>();
        for (int a = 1; a < N; a++) {
            for (int b = a + 1; b <= N; b++) {
                int sum = 0;
                for (int i = 1; i <= N; i++) {
                    sum += Math.min(spt[a][i] + spt[i][a], spt[b][i] + spt[i][b]);
                }
                buildings.add(new Building(a, b, sum));
            }
        }
        Collections.sort(buildings);
        Building result = buildings.get(0);

        // 건물 2개가 지어질 건물 번호 오름차순 출력 및 왕복 시간의 합 출력
        System.out.printf("%d %d %d\n", result.index[0], result.index[1], result.time);
    }
}
