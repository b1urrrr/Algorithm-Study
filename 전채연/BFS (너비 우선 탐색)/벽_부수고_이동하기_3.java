/*
    백준 16933번 : 벽 부수고 이동하기 3
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 벽_부수고_이동하기_3 {
    static int n, m, k;
    static int[][] graph;
    static int[][][] visited; // 위치와 벽을 부순 여부에 대한 방문 처리
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int broke;
        boolean isDay;

        Node(int x, int y, int broke, boolean isDay) {
            this.x = x;
            this.y = y;
            this.broke = broke;
            this.isDay = isDay;
        } 
    }

    static int bfs() {
        Queue<Node> que = new LinkedList<>();
        visited[0][0][0] = 1;
        que.add(new Node(0, 0, 0, true));

        while (!que.isEmpty()) {
            Node next = que.remove();
            boolean stay = false;

            // 목적지에 도착했다면 결과 반환하고 종료
            if (next.x == n - 1 && next.y == m - 1) return visited[next.x][next.y][next.broke];

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 지도의 범위를 벗어난 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                // 벽이 아닌 경우
                if (graph[nx][ny] == 0) {
                    if (visited[nx][ny][next.broke] == 0) {
                        visited[nx][ny][next.broke] = visited[next.x][next.y][next.broke] + 1;
                        que.add(new Node(nx, ny, next.broke, !next.isDay));
                    }
                } 
                // 벽인 경우
                else {
                    // 벽을 부술 수 있는 경우
                    if (next.broke < k && visited[nx][ny][next.broke + 1] == 0) {
                        // 밤인 경우 하루 머무르기
                        if (!next.isDay) {
                            stay = true;
                            continue;
                        }
                        visited[nx][ny][next.broke + 1] = visited[next.x][next.y][next.broke] + 1;
                        que.add(new Node(nx, ny, next.broke + 1, !next.isDay));
                    }
                }
            }

            // 하루 머무르는 경우
            if (stay) {
                visited[next.x][next.y][next.broke]++;
                que.add(new Node(next.x, next.y, next.broke, !next.isDay));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로 칸의 개수 입력
        m = Integer.parseInt(st.nextToken()); // 가로 칸의 개수 입력
        k = Integer.parseInt(st.nextToken()); // 부술 수 있는 벽의 개수 입력
        graph = new int[n][m];
        visited = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0'; // 맵 입력
            }
        }

        // 최단 거리 출력
        if (n == 1 && m == 1) System.out.println(1); // 맵이 한 칸인 경우는 1 출력
        else System.out.println(bfs());
    }
}
