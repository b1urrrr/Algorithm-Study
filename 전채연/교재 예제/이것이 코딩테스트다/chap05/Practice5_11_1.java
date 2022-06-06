package chap05;

import java.io.*;
import java.util.StringTokenizer;

public class Practice5_11_1 {
    static int n, m; // 세로와 가로의 길이
    static int[][] graph;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    static void dfs(int x, int y, int step) {
        visited[x][y] = true;
        step++;

        if (x == n - 1 && y == m - 1) {
            min = Math.min(min, step);
            return;
        }

        // x + 1, y
        if (x + 1 < n && !visited[x + 1][y] && graph[x + 1][y] == 1) {
            dfs(x + 1, y, step);
            visited[x + 1][y] = false;
        }
        // x - 1, y
        if (x - 1 >= 0 && !visited[x - 1][y] && graph[x - 1][y] == 1) {
            dfs(x - 1, y, step);
            visited[x - 1][y] = false;
        }
        // x, y + 1
        if (y + 1 < m && !visited[x][y + 1] && graph[x][y + 1] == 1) {
            dfs(x, y + 1, step);
            visited[x][y + 1] = false;
        }
        // x, y - 1
        if (y - 1 >= 0 && !visited[x][y - 1] && graph[x][y - 1] == 1) {
            dfs(x, y - 1, step);
            visited[x][y - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        dfs(0, 0, 0);

        System.out.println(min);
    }
}
