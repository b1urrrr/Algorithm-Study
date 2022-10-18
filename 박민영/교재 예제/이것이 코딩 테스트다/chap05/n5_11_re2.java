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

public class n5_11_re2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0));
        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int x = nowNode.getX();
            int y = nowNode.getY();

            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // 벽(괴물)인 경우 무시
                if (map[nx][ny] == 0) {
                    continue;
                }

                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[x][y] + 1; // 값을 +1 누적해서 변경
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        System.out.println(map[n-1][m-1]);
    }
}
