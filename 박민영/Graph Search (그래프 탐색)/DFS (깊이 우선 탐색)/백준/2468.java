/*
 * @author Minyeong Park
 * @date 2023.03.16.
 * 안전 영역
 * 문제 링크 : https://www.acmicpc.net/problem/2468
 */



import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n]; // (n+1)*(n+1)로 하려고 했었는데 그냥 n*n으로 설정하면 됨
        StringTokenizer st;
        int max_height = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(max_height, arr[i][j]);
            }
        }

        int max = 0;
        // 1. 모든 지역 탐색
        for (int h = 0; h < max_height + 1; h++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 2. 안전 영역 탐지
                    if (!visited[i][j] && arr[i][j] > h) {
                        cnt += dfs(i, j, h); // 해당 안전 영역 탐색 시작
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    // 안전 영역 DFS 탐색
    static int dfs(int x, int y, int h) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1)
                continue;
            if (visited[nx][ny])
                continue;
            if (arr[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
        return 1;
    }
}