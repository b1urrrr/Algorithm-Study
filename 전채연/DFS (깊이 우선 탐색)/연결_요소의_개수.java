import java.io.*;
import java.util.StringTokenizer;

public class 연결_요소의_개수 {
    static boolean[][] graph;
    static boolean[] visited;
    static int n;

    // 깊이 우선 탐색 메서드
    static void dfs(int node) {
        visited[node] = true; // 방문 처리

        for (int i = 1; i <= n; i++) {
            // 이미 방문한 노드인 경우
            if (visited[i]) continue;
            // 연결된 노드인 경우
            if (graph[node][i]) dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 간선의 양 끝 점
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = true;
            graph[v][u] = true;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 노드에 대해 깊이 우선 탐색 실행
            if (!visited[i + 1]) {
                dfs(i + 1);
                count++;
            }
        }

        // 연결 요소의 개수 출력
        System.out.println(count);
    }
}
