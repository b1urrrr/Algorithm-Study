/*
    백준 2644번 : 촌수계산
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;

public class 촌수계산 {
    static int n;
    static boolean[][] graph;
    static int[] visited;

    // 깊이 우선 탐색 메서드
    static void dfs(int node) {
        for (int i = 1; i <= n; i++) {
            // 이미 방문한 노드인 경우 무시
            if (visited[i] > 0) continue;
            // 촌수 관계면 깊이 우선 탐색 실행
            if (graph[node][i]) {
                visited[i] = visited[node] + 1; // 방문처리
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 전체 사람의 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 촌수를 계산해야하는 두 사람의 번호 입력
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine()); // 관계의 개수 입력
        graph = new boolean[n + 1][n + 1];
        visited = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 부모자식 관계를 나타내는 두 번호 입력
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        visited[start] = 1; // 방문처리
        dfs(start); // 깊이 우선 탐색

        // 두 사람의 촌수를 나타내는 정수를 출력
        if (visited[end] == 0) System.out.println(-1);
        else System.out.println(visited[end] - 1);
    }
}
