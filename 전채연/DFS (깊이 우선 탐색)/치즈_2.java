/*
    백준 2636번 : 치즈
    - 문제 유형 : 그래프 탐색, 시뮬레이션
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;

public class 치즈_2 {
    static int n, m, cheese = 0, hour = 0, result;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 치즈 상태를 초기화하는 메서드
    static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 빈 공간이었던 노드
                if (graph[i][j] == -1) graph[i][j] = 0;
                // 치즈가 녹는 노드
                else if (graph[i][j] > 1) {
                    graph[i][j] = 0;
                    cheese--;
                } 
                // 치즈가 녹지 않는 노드
                else if (graph[i][j] == 2) {
                    graph[i][j] = 1;
                }
            }
        }
    }

    // 깊이 우선 탐색 메서드
    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어난 경우
            if (nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
            // 이미 방문한 노드인 경우
            if (graph[nx][ny] == -1) continue;
            // 치즈가 있는 노드인 경우
            if (graph[nx][ny] > 0) {
                graph[nx][ny]++;
                continue;
            }
            
            graph[nx][ny] = -1; // -1로 방문 처리
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 모눈종이의 세로 칸 개수 입력
        m = Integer.parseInt(st.nextToken()); // 모눈종이의 가로 칸 개수 입력
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken()); // 치즈 존재 여부 입력
                if (graph[i][j] == 1) cheese++;
            }
        }

        // 치즈가 다 녹기 전까지 깊이 우선 탐색 반복
        while (cheese > 0) {
            result = cheese;
            graph[0][0] = -1; // 시작 노드 방문 처리
            dfs(0, 0);
            hour++;
            init();
        }

        // 주어진 치즈가 모두 녹는 데 걸리는 시간 출력
        System.out.println(hour);
        System.out.println(result);
    }
}
