/*
 * @author Minyeong Park
 * @date 2023.10.01.
 * 쉬운 최단거리
 * 문제 링크 : https://www.acmicpc.net/problem/14940
 * 참고 : https://velog.io/@kry-p/%EB%B0%B1%EC%A4%80-14940-%EC%89%AC%EC%9A%B4-%EC%B5%9C%EB%8B%A8%EA%B1%B0%EB%A6%AC-Java#%EC%A7%80%EB%8F%84-%EC%9E%85%EB%A0%A5-%EB%B0%8F-%EC%8B%9C%EC%9E%91%EC%A0%90-%EC%B0%BE%EA%B8%B0
 */


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, goal_x, goal_y;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    goal_x = i;
                    goal_y = j;
                }
            }
        }

        bfs(goal_x, goal_y); // 목표지점으로부터 각 지점까지의 거리를 구한다!

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) // 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치
                    sb.append(-1 + " ");
                else
                    sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        visited = new boolean[n][m];
        int count = 0;

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x,y}); // 지금 방문한 곳을 큐에 넣음
        visited[x][y] = true; // 방문 처리

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            q.poll();

            // 상하좌우 탐색 진행
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) { // map 안의 위치인지 확인
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        distance[nx][ny] = distance[x][y] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}