// chap05 (4) 실전 문제 : 미로 탈출
// 막혀서 결국.. 해설 코드를 보면서 이해하는 방식으로 공부했다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private int x;
    private int y;

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

public class n5_11 {
    static int n, m;
    static int[][] arr = new int[201][201];

    // 이동할 네 가지 방향 정의 (상하좌우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }

    static int bfs(int x, int y) {
        // 큐 구현
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        // 큐가 빌 때까지 반복하기
        while (!q.isEmpty()) {
            Node node = q.poll(); // 큐에서 빼낸 노드
            x = node.getX();
            y = node.getY();

            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) { // 이렇게 0 ~ 4까지 돌면서
                int nx = x + dx[i];       // 상하좌우 값을 대입
                int ny = y + dy[i];

                // 미로찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 벽인 경우 무시
                if (arr[nx][ny] == 0) continue;

                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1; // 값을 +1 누적해서 변경
                    q.offer(new Node(nx, ny));   // 이 노드를 큐에 넣어서 후에 이 노드를 진행하도록 함
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return arr[n-1][m-1];
    }
}
