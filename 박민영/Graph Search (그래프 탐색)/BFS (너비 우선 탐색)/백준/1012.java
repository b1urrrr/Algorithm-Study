/*
 * @author Minyeong Park
 * @date 2023.09.24.
 * 유기농 배추
 * 문제 링크 : https://www.acmicpc.net/problem/1012
 * 참고 : https://1-7171771.tistory.com/59
 */


import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] check;
    static int cnt;

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y}); // 일단 지금 방문한 곳을 큐에 넣음

        while (!q.isEmpty()) { // 큐가 빌 때까지 반복
            x = q.peek()[0];
            y = q.peek()[1];
            check[x][y] = true; // 방문 처리
            q.poll();

            // 상하좌우에 대해 탐색 진행
            for (int i = 0; i < 4; i++) { // dx, dy를 조합하면 상하좌우 탐색이 가능
                int change_x = x + dx[i];
                int change_y = y + dy[i];

                if (change_x >= 0 && change_x < m && change_y >= 0 && change_y < n) { // map 안의 위치인지 확인
                    if (!check[change_x][change_y] && map[change_x][change_y] == 1) { // 이 위치를 방문한 적이 없고, 1인 위치이면
                        q.add(new int[]{change_x, change_y});
                        check[change_x][change_y] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int c = 0; c < t; c++) {
            String[] infos = br.readLine().split(" ");
            m = Integer.parseInt(infos[0]);
            n = Integer.parseInt(infos[1]);
            int k = Integer.parseInt(infos[2]);

            map = new int[m][n];
            for (int i = 0; i < k; i++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                map[x][y] = 1;
            }

            check = new boolean[m][n];
            cnt = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !check[i][j]) { // 방문하지 않았던 현재 위치에 대해 bfs 탐색
                        bfs(i, j); // 인접한 모든 1을 방문처리하고 옴
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}