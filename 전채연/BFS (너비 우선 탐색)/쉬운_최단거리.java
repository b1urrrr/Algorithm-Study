import java.io.*;
import java.util.*;

public class 쉬운_최단거리 {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        map[x][y] = 3;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));

        while (!que.isEmpty()) {
            Node next = que.remove();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 지도 범위를 벗어난 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 갈 수 없는 땅인 경우
                if (map[nx][ny] == 0) continue;
                // 이미 방문한 땅인 경우
                if (map[nx][ny] > 2) continue;

                map[nx][ny] = map[next.x][next.y] + 1;
                que.add(new Node(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        Node start = new Node(-1, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) start = new Node(i, j);
            }
        }

        bfs(start.x, start.y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) System.out.print(0 + " ");
                else if (map[i][j] == 1) System.out.print(-1 + " ");
                else System.out.print(map[i][j] - 3 + " ");
            }
            System.out.println();
        }
    }
}
