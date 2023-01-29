/*
 * @author Minyeong Park
 * @date 2023.01.29.
 * 미로 탐색 (BFS) (다른 풀이 공부)
 * 출처 : https://iseunghan.tistory.com/312
 * 문제 링크 : https://www.acmicpc.net/problem/2178
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] arr;
    static int min_cnt = 10000;
    static int[][] dist; // 거리를 계산할 dist 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n+1][m+1];
        dist = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = line.charAt(j-1);
                dist[i][j] = -1; // 거리를 -1로 세팅하면, 방문 여부를 확인 가능.
            }
        }

        bfs(1,1);
        // 마지막 지점의 (거리 + 1)를 출력해주면 됨. (칸을 셀 때 시작위치도 포함하기 때문)
        System.out.println(dist[n][m] + 1);
    }

    static void bfs(int start_x, int start_y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start_x, start_y));
        dist[start_x][start_y] = 0; // 첫 시작이니까 거리가 0

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            // 상하좌우 칸 확인
            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                // 벽에 부딪히거나, 범위를 넘어가면 pass
                if (next_x <= 0 || next_y <= 0 || next_x > n || next_y > m) {
                    continue;
                }

                // 길이 아니거나, 방문을 했다면 pass
                if (arr[next_x][next_y] == '0' || dist[next_x][next_y] != -1) {
                    continue;
                }

                // 큐에 이동한 좌표를 넣어줌
                queue.offer(new Node(next_x, next_y));
                // 한 칸 이동했기 때문에, 이전 출발지점의 거리 +1을 해준다.
                dist[next_x][next_y] = dist[x][y] + 1;
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}