import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 벽_부수고_이동하기 {
    static int n, m;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        } 
    }

    static int bfs() {
        Queue<Node> que = new LinkedList<>();
        boolean[][] broken = new boolean[n][m]; // 벽을 부순 적 있는지 기록
        graph[0][0] = 1;
        que.add(new Node(0, 0));

        while (!que.isEmpty()) {
            Node next = que.remove();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 지도의 범위를 벗어난 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || (nx == 0 && ny == 0)) continue;
                // 이미 방문한 노드인 경우
                if (graph[nx][ny] > 1 && (broken[next.x][next.y] || !broken[nx][ny])) continue;
                // 벽인 경우
                if (graph[nx][ny] == 1) {
                    // 벽을 부순 적이 있는 경우
                    if (broken[next.x][next.y]) continue;
                    // 벽을 부순 적이 없으면 부수기
                    broken[nx][ny] = true;
                    System.out.println("BREAK!");
                }

                que.add(new Node(nx, ny));
                graph[nx][ny] = graph[next.x][next.y] + 1;
                broken[nx][ny] = broken[next.x][next.y] || broken[nx][ny];

                /*
                 * 테스트용 출력
                 */
                for (int ti = 0; ti < n; ti++) {
                    for (int tj = 0; tj < m; tj++) {
                        System.out.printf("%3d", graph[ti][tj]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

        if (graph[n - 1][m - 1] == 0) return -1;
        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
