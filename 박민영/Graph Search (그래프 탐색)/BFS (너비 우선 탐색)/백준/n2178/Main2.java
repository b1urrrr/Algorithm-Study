/*
 * @author Minyeong Park
 * @date 2023.01.29.
 * 미로 탐색 (처음에 dfs로 풀었던 풀이 -> 시간초과가 떠서 적합하지는 않지만 정답은 나옴)
 * 문제 링크 : https://www.acmicpc.net/problem/2178
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] arr;
    static int min_count = 10000;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = line.charAt(j-1);
            }
        }

        dfs(1,1, 1);
        System.out.println(min_count);
    }

    static void dfs(int x, int y, int count) {
        visited[x][y] = true;
        if (x == n && y == m && count < min_count) {
            min_count = count;
            return;
        }

        // 상하좌우 칸 확인
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x <= 0 || next_y <= 0 || next_x > n || next_y > m) {
                continue;
            }

            if (arr[next_x][next_y] == '1' && !visited[next_x][next_y]) {
                dfs(next_x, next_y, count + 1);
                visited[next_x][next_y] = false;
            }
        }
    }
}