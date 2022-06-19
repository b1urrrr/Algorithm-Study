/*
    백준 2468번 : 안전 영역
    - 문제 유형 : 그래프 탐색, 브루트 포스
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;

public class 안전_영역 {
    static int[][] graph;
    static int N, max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 깊이 우선 탐색 메서드
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
        N = Integer.parseInt(br.readLine()); // 2차원 배열의 행과 열의 개수 입력
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken()); // 높이 정보 입력
            }
        }

        int max = 0; // 물에 잠기지 않는 안전한 영역의 최대 개수
        for (int i = 0; i <= 100; i++) {
            boolean[][] visited = new boolean[N][N];
            int count = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (graph[x][y] > i && !visited[x][y]) {
                        count++; // 안전한 영역 발견 시 개수 증가
                        dfs(x, y, i, visited);
                    }
                }
            }
            max = Math.max(max, count); // 최대값 저장
        }

        // 결과 출력
        System.out.println(max);
    }
}