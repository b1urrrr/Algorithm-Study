/*
    백준 1012번 : 욕심쟁이 판다
    - 문제 유형 : 그래프 탐색, 다이나믹 프로그래밍
    - 풀이 유형 : DFS (깊이 우선 탐색), 다이나믹 프로그래밍
*/

import java.io.*;
import java.util.StringTokenizer;

public class 욕심쟁이_판다 {

    static int n, max = 1;
    static int[][] forest, visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 깊이 우선 탐색 메서드
    static int dfs(int x, int y) {
        int count = 1; // (x, y)의 이동 가능 칸 수

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 숲의 범위를 벗어난 경우
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            // 전 지역보다 대나무가 많지 않은 경우
            if (forest[x][y] >= forest[nx][ny]) continue;

            // (nx, ny)의 이동 가능 칸 수를 구한 경우
            if (visited[nx][ny] > 0) count = Math.max(count, 1 + visited[nx][ny]);
            // (nx, ny)의 이동 가능 칸 수를 구하지 않은 경우
            else count = Math.max(count, 1 + dfs(nx, ny));
        }

        visited[x][y] = count;
        max = Math.max(max, count); // 현재까지 이동 가능 칸 수의 최대값 계산
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 대나무 숲의 크기 n 입력
        forest = new int[n][n];
        visited = new int[n][n]; // 이동 가능 칸수의 최대값 배열

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken()); // 대나무 숲의 정보 입력
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 이동 가능 칸 수를 구하지 않은 칸이면 깊이 우선 탐색 실행
                if (visited[i][j] == 0) dfs(i, j);
            }
        }

        // 판다가 이동할 수 있는 칸의 수의 최댓값 출력
        System.out.println(max);
    }
}
