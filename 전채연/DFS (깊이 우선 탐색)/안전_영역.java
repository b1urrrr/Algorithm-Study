/*
    백준 2468번 : 안전 영역
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;

public class 안전_영역 {
    static int[][] graph;
    static int N, max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y, int rain, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어난 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            // 이미 방문한 노드인 경우
            if (visited[nx][ny]) continue;

            if (graph[nx][ny] > rain) dfs(nx, ny, rain, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i <= 100; i++) {
            boolean[][] visited = new boolean[N][N];
            int count = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (graph[x][y] > i && !visited[x][y]) {
                        count++;
                        dfs(x, y, i, visited);
                    }
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}