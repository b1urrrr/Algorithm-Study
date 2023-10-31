/*
    백준 12886번 : 돌 그룹
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
*/

import java.io.*;
import java.util.*;

public class 돌_그룹 {
    static int result = 0;
    static boolean[][] visited;
    static int[] stones = new int[3];
    static int[] groupA = {0, 0, 1, 1, 2, 2};
    static int[] groupB = {1, 2, 2, 0, 0, 1};

    static void bfs() {
        if (result == 1) return;
        if (stones[0] == stones[1] && stones[1] == stones[2]) {
            result = 1;
            return;
        }
        visited[stones[0]][stones[1]] = true;

        for (int i = 0; i < 5; i++) {
            int small = groupA[i];
            int big = groupB[i];
            int smallCnt = stones[small];
            int bigCnt = stones[big];

            if (smallCnt > bigCnt) continue;

            stones[big] -= smallCnt;
            stones[small] += smallCnt;
            if (!visited[stones[0]][stones[1]]) bfs();
            stones[big] += smallCnt;
            stones[small] -= smallCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        stones[0] = Integer.parseInt(st.nextToken());
        stones[1] = Integer.parseInt(st.nextToken());
        stones[2] = Integer.parseInt(st.nextToken());

        int max = stones[0] + stones[1] + stones[2] + 1;
        visited = new boolean[max][max];

        bfs();
        System.out.println(result);
    }
}
