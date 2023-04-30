/*
    백준 1600번 : 말이 되고픈 원숭이
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
*/

import java.io.*;
import java.util.*;

public class 말이_되고픈_원숭이 {
    static int K, W, H;
    static int[][] grid;
    static boolean[][][] visited;
    static int[] horseX = {-2, -2, -1, -1, 1, 1, 2, 2}, monkeyX = {-1, 1, 0, 0};
    static int[] horseY = {1, -1, 2, -2, 2, -2, 1, -1}, monkeyY = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int k;
        int move;

        public Node(int x, int y, int k, int move) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.move = move;
        }
    }

    /** 방문 가능한 칸인지 반환 */
    static boolean isValidPlace(int x, int y, int k) {
        return x < 0 || x >= H || y < 0 || y >= W || grid[x][y] == 1 || visited[x][y][k];
    }

    /** 원숭이의 동작에 대해 너비 우선 탐색 수행 */
    static int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!que.isEmpty()) {
            Node next = que.remove();
            if (next.x == H - 1 && next.y == W - 1) return next.move;

            // 말처럼 이동하는 경우
            if (next.k < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = next.x + horseX[i];
                    int ny = next.y + horseY[i];

                    if (isValidPlace(nx, ny, next.k + 1)) continue;
                    visited[nx][ny][next.k + 1] = true;
                    que.add(new Node(nx, ny, next.k + 1, next.move + 1));
                }
            }

            // 원숭이처럼 이동하는 경우
            for (int i = 0; i < 4; i++) {
                int nx = next.x + monkeyX[i];
                int ny = next.y + monkeyY[i];

                if (isValidPlace(nx, ny, next.k)) continue;
                visited[nx][ny][next.k] = true;
                que.add(new Node(nx, ny, next.k, next.move + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // 말처럼 이동 가능한 횟수 K 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 격자판의 가로 길이 W 입력
        H = Integer.parseInt(st.nextToken()); // 격자판의 세로 길이 H 입력
        grid = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken()); // 평지 : 0, 장애물 : 1
            }
        }

        // 너비 우선 탐색 수행 후 원숭이의 동작수의 최솟값을 출력
        System.out.println(bfs());
    }
}
