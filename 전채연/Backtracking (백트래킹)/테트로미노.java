/*
    백준 14500번 : 테트로미노
    - 문제 유형 : 브루트포스 알고리즘
    - 풀이 유형 : 백트래킹, 브루트포스
*/

import java.io.*;
import java.util.StringTokenizer;

public class 테트로미노 {
    static int n, m, result;
    static int[][] paper;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void dfs(int x, int y, int sum, int depth) {
        if (depth > 3) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            if (moveX < 0 || moveY < 0 || moveX >= n || moveY >= m || visit[moveX][moveY]) continue;

            visit[moveX][moveY] = true;
            dfs(moveX, moveY, sum + paper[moveX][moveY], depth + 1);
            visit[moveX][moveY] = false;
        }
    }

    static void exception(int x, int y) {
        // 'ㅗ' 모양인 경우 탐색
        if (y - 1 >= 0 && x - 1 >= 0 && y + 1 < m) {
            int sum = paper[x][y] + paper[x][y - 1] + paper[x - 1][y] + paper[x][y + 1];
            result = Math.max(result, sum);
        }
        // 'ㅏ' 모양인 경우 탐색
        if (x - 1 >= 0 && y + 1 < m && x + 1 < n) {
            int sum = paper[x][y] + paper[x - 1][y] + paper[x][y + 1] + paper[x + 1][y];
            result = Math.max(result, sum);
        }
        // 'ㅜ' 모양인 경우 탐색
        if (y - 1 >= 0 && x + 1 < n && y + 1 < m) {
            int sum = paper[x][y] + paper[x][y - 1] + paper[x + 1][y] + paper[x][y + 1];
            result = Math.max(result, sum);
        }
        // 'ㅓ' 모양인 경우 탐색
        if (x + 1 < n && y - 1 >= 0 && x - 1 >= 0) {
            int sum = paper[x][y] + paper[x + 1][y] + paper[x][y - 1] + paper[x - 1][y];
            result = Math.max(result, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, paper[i][j], 1);
                visit[i][j] = false;
                exception(i, j);
            }
        }

        System.out.println(result);
    }
}
