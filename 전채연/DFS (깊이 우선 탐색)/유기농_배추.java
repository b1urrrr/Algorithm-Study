/*
    백준 1012번 : 유기농 배추
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/


import java.io.*;
import java.util.StringTokenizer;

public class 유기농_배추 {
    static int m, n; // 배추밭의 가로 길이, 세로 길이 그리고 배추가 심어져 있는 위치의 개수
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배추밭의 범위를 벗어난 경우 무시
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            // 배추가 없는 곳인 경우 무시
            if (graph[nx][ny] == 0) continue;
            // 아직 방문하지 않은 경우 재귀적으로 깊이 우선 탐색 진행
            if (!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로 길이 입력
            n = Integer.parseInt(st.nextToken()); // 세로 길이 입력
            int k = Integer.parseInt(st.nextToken()); // 배추의 위치 개수 입력
            graph = new int[n][m];
            visited = new boolean[n][m];
            int count = 0;

            // 배추 위치 입력
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            // 아직 방문하지 않은 배추의 위치가 있으면 깊이 우선 탐색 진행
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (graph[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
