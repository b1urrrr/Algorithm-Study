package chap04;

import java.io.*;
import java.util.StringTokenizer;

public class Practice4_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로 크기
        int m = Integer.parseInt(st.nextToken()); // 가로 크기

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        visited[x][y] = true;
        int visit = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        Sim : while(true) {
            for (int i = 0; i < 4; i++) {
                if (dir == 0) dir = 3;
                else dir--;
                int tempX = x + dx[dir];
                int tempY = y + dy[dir];
                if (tempX < 0 || tempX >= n || tempY < 0 || tempY >= m || visited[tempX][tempY] || map[tempX][tempY] == 1) continue;
                x = tempX; y = tempY; visited[x][y] = true; visit++; continue Sim;
            }
            break;
        }

        System.out.println(visit);
    }
}
