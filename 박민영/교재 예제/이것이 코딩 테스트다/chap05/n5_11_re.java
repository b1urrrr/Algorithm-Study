// chap05 (4) 미로 탈출 (다시 풀기)
// 다시 풀었으나.. 막혔다... 해설이랑 코드 보면서 원리 이해함...
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private int x, y;

    public Node(int x, int y) {
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

public class n5_11_re {
    static int n, m;
    static int[][] graph;

    // 이동할 네 가지 방향 정의 (상하좌우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(x,y));

        // 큐가 빌 때까지 반복하기
        while (!queue.isEmpty()) {
            Node node = queue.poll(); // 큐에서 빼낸 노드
            x = node.getX();
            y = node.getY();

            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                // 벽인 경우 무시
                if (graph[nx][ny] == 0)
                    continue;

                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1; // 값을 +1 누적해서 변경
                    queue.offer(new Node(nx, ny)); // 해당 노드를 큐에 넣음
                }
            }
        }

        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n-1][m-1];
    }
}
