/*
    백준 4963번 : 섬의 개수
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;

public class 섬의_개수 {
    static int w, h;
    static boolean[][] map;
    static int[] dx = {-1, 1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    // 깊이 우선 탐색 메서드
    static void dfs(int x, int y) {
        map[x][y] = false;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도의 범위를 벗어난 경우 무시
            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            // 땅인 경우 깊이 우선 탐색 실행
            if (map[nx][ny]) dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 너비 입력
            h = Integer.parseInt(st.nextToken()); // 높이 입력
            map = new boolean[h][w];

            // 0 0 이 입력된 경우 종료
            if (w == 0 && h == 0) return ;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int tile = Integer.parseInt(st.nextToken());
                    // 땅인 경우 기록
                    if (tile == 1) map[i][j] = true;
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 땅인 경우 깊이 우선 탐색 실행
                    if (map[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            // 섬의 개수 출력
            System.out.println(count);
        }
    }
}
