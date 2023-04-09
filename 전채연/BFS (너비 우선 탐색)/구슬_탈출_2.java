/*
    백준 13460번 : 구슬 탈출 2
    - 문제 유형 : 구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색, 시뮬레이션
*/

import java.io.*;
import java.util.*;

public class 구슬_탈출_2 {
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Position {
        Coordinate red;
        Coordinate blue;
        int spin;

        public Position(Coordinate red, Coordinate blue, int spin) {
            this.red = red;
            this.blue = blue;
            this.spin = spin;
        }
    }

    static int bfs(Position start) {
        Queue<Position> que = new LinkedList<>();
        visited[start.red.x][start.red.y] = true;
        que.add(start);

        while (!que.isEmpty()) {
            Position next = que.remove();
            if (next.spin >= 10) return -1;

            Spin : for (int i = 0; i < 4; i++) {
                int redx = next.red.x;
                int redy = next.red.y;
                int bluex = next.blue.x;
                int bluey = next.blue.y;

                int rx = next.red.x, ry = next.red.y;
                int bx = next.blue.x, by = next.blue.y;

                boolean isRedHole = false, isRedStop = false, isBlueStop = false;
                while (true) {
                    if (!isRedStop && !isRedHole) {
                        redx += dx[i];
                        redy += dy[i];

                        // 범위를 벗어난 경우
                        if (redx < 0 || redx >= N || redy < 0 || redy >= M) isRedStop = true;
                        // 장애물인 경우
                        else if (board[redx][redy] == '#') isRedStop = true;
                        // 구멍인 경우
                        else if (board[redx][redy] == 'O') isRedStop = isRedHole = true;
                    }

                    if (!isBlueStop) {
                        bluex += dx[i];
                        bluey += dy[i];

                        // 범위를 벗어난 경우
                        if (bluex < 0 || bluex >= N || bluey < 0 || bluey >= M) isBlueStop = true;
                        // 장애물인 경우
                        else if (board[bluex][bluey] == '#') isBlueStop = true;
                        // 구멍인 경우
                        else if (board[bluex][bluey] == 'O') continue Spin;
                    }

                    // 다른 구슬에 의해 멈춘 경우
                    if (isBlueStop && redx == bx && redy == by) isRedStop = true;
                    if (isRedStop && !isRedHole && bluex == rx && bluey == ry) isBlueStop = true;

                    if (!isRedStop) { rx = redx; ry = redy; }
                    if (!isBlueStop) { bx = bluex; by = bluey; }
                    if (isRedStop && isBlueStop) break;
                }

                if (isRedHole) return next.spin + 1;

                // 구슬들이 모두 제자리인 경우
                if (next.red.x == rx && next.red.y == ry && next.blue.x == bx && next.blue.y == by) continue;

                visited[rx][ry] = true;
                que.add(new Position(new Coordinate(rx, ry), new Coordinate(bx, by), next.spin + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 보드의 세로 길이 N 입력
        M = Integer.parseInt(st.nextToken()); // 보도의 가로 길이 M 입력
        board = new char[N][M];
        visited = new boolean[N][M];

        Coordinate red = null, blue = null;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j); // 보드의 모양 입력
                if (board[i][j] == 'R') red = new Coordinate(i, j);
                else if (board[i][j] == 'B') blue = new Coordinate(i, j); 
            }
        }

        // 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력 (10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1 출력)
        System.out.println(bfs(new Position(red, blue, 0)));
    }
}
