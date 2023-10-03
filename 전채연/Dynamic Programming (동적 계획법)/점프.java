/*
    백준 1890번 : 점프
    - 문제 유형 : 다이나믹 프로그래밍
*/

import java.io.*;
import java.util.*;

public class 점프 {
    static int N;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static long[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 게임 판의 크기 N 입력
        visited = new long[N][N];
        visited[0][0] = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                long distance = Integer.parseInt(st.nextToken()); // 현재 칸에서 갈 수 있는 거리 입력
                if (distance == 0) continue;

                for (int d = 0; d < 2; d++) {
                    long nx = i + (dx[d] * distance);
                    long ny = j + (dy[d] * distance);

                    // 보드의 크기를 벗어난 경우
                    if (nx >= N || ny >= N) continue;

                    visited[(int) nx][(int) ny] += visited[i][j];
                }
            }
        }

        // 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 문제의 규칙에 맞게 갈 수 있는 경로의 개수를 출력
        System.out.println(visited[N - 1][N - 1]);
    }
}
