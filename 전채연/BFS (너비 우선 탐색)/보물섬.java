/*
    백준 2589번 : 보물섬
    - 문제 유형 : 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 보물섬 {
    static char[][] map;
    static int height, width;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /** 보물지도 너비 우선 탐색 함수 */
    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        int[][] visited = new int[height][width];
        visited[x][y] = 1;

        while(!que.isEmpty()) {
            Node next = que.remove();
            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 지도 크기를 벗어난 경우
                if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;
                // 이미 방문한 경우
                if (visited[nx][ny] > 0) continue;
                // 바다인 경우
                if (map[nx][ny] == 'W') continue;

                // 탐색 수행
                que.add(new Node(nx, ny));
                visited[nx][ny] = visited[next.x][next.y] + 1;
                max = Math.max(max, visited[nx][ny] - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken()); // 보물 지도의 세로 크기 입력
        width = Integer.parseInt(st.nextToken()); // 보물 지도의 가로 크기 입력
        map = new char[height][width];

        for (int i = 0; i < height; i++) {
            String mark = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = mark.charAt(j); // 지도 (i, j)의 표시 입력
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // 육지인 경우 너비 우선 탐색 수행
                if (map[i][j] == 'L') bfs(i, j);
            }
        }

        // 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간 출력
        System.out.println(max);
    }
}
