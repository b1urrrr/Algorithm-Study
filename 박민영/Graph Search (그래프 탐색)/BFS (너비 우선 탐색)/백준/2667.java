/*
 * @author Minyeong Park
 * @date 2023.03.19.
 * 단지번호붙이기
 * 막히는 부분 참고 : https://pangsblog.tistory.com/28
 * 문제 링크 : https://www.acmicpc.net/problem/2667
 */



import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j])
                    bfs(i, j);
            }
        }

        // 큐의 사이즈 = 단지의 수
        System.out.println(pq.size());

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static void bfs(int start_x, int start_y) {
        Queue<Home> q = new LinkedList<>();
        int temp_home_cnt = 0;
        q.offer(new Home(start_x, start_y));
        visited[start_x][start_y] = true;
        temp_home_cnt++;
        while (!q.isEmpty()) {
            Home now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        temp_home_cnt++;
                        q.offer(new Home(nx, ny));
                    }
                }
            }
        }

        pq.offer(temp_home_cnt);
    }
}

class Home {
    int x,y;

    public Home(int x, int y) {
        this.x = x;
        this.y = y;
    }
}