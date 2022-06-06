package chap05;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Practice5_11_2 {
    static int n, m;
    static int[][] graph;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        private int x;
        private int y;
    
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
        public int getX() {
            return x;
        }
    
        public int getY() {
            return y;
        }
    }

    static int bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));

        while (!que.isEmpty()) {
            Node node = que.remove();
            x = node.getX();
            y = node.getY();

            // 4 방향으로 이동하는 경우 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로의 범위를 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 괴물이 있는 부분(0)이면 무시
                if (graph[nx][ny] == 0) continue;
                // 해당 노드를 방문한 적이 없으면 최단 거리 기록
                if (graph[nx][ny] == 1) { // visited 배열 대신 값이 1인 경우, 방문하지 않은 상태임
                    graph[nx][ny] = graph[x][y] + 1;
                    que.add(new Node(nx, ny));
                }
            }
        }
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

        System.out.println(bfs(0, 0));
    }
}
