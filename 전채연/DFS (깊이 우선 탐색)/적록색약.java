/*
    백준 10026번 : 적록색약
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/

import java.io.*;

public class 적록색약 {
    static int n; // 그리드 한 변의 길이
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int normal = 0, colorBlind = 0;

    // 구역의 개수 너비 우선 탐색 함수
    static void dfs(int x, int y, char color, boolean[][] visited, char[][] graph) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 탐색 노드가 그리드의 범위를 벗어난 경우 무시
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            // 방문한 적이 있는 노드면 무시
            if (visited[nx][ny]) continue;
            if (graph[nx][ny] == color) {
                dfs(nx, ny, color, visited, graph);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 그리드 한 변의 길이 입력
        char[][] normalGraph = new char[n][n]; // 적록색약이 아닌 사람들이 보는 그림 그래프
        char[][] colorBlindGraph = new char[n][n]; // 적록색약인 사람들이 보는 그림 그래프
        boolean[][] normalVisited = new boolean[n][n];
        boolean[][] colorBlindVisited = new boolean[n][n];

        // 그림 입력
        for (int i = 0; i < n; i++) {
            String drawing = br.readLine();
            for (int j = 0; j < n; j++) {
                normalGraph[i][j] = drawing.charAt(j);
                // 빨강인 경우 적록색약 그래프에는 초록으로 바꿔서 저장
                if (drawing.charAt(j) == 'R') colorBlindGraph[i][j] = 'G';
                else colorBlindGraph[i][j] = drawing.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않은 노드인 경우 너비 우선 탐색 시작
                if (!normalVisited[i][j]) {
                    dfs(i, j, normalGraph[i][j], normalVisited, normalGraph);
                    normal++;
                }
                if (!colorBlindVisited[i][j]) {
                    dfs(i, j, colorBlindGraph[i][j], colorBlindVisited, colorBlindGraph);
                    colorBlind++;
                }
            }
        }

        // 구역의 수 출력
        System.out.println(normal + " " + colorBlind);
    }
}
