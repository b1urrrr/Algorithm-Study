/*
    백준 4179번 : 불!
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
*/

import java.io.*;
import java.util.*;

public class 불_ {
    static char[][] maze;
    static boolean[][] visited;
    static int R, C;
    static PriorityQueue<Node> que = new PriorityQueue<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static enum Type {
        Jihun, Fire
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        Type type;
        int time;

        Node(int x, int y, Type type, int time) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            if (this.time == other.time) {
                if (this.type == other.type) return 0;
                if (this.type == Type.Fire) return -1;
                return 1;
            }
            return this.time - other.time;
        }
    }

    /** 노드에 대해 탈출 가능 여부 반환 */
    static boolean isAnswer(Node node) {
        return node.type == Type.Jihun && (node.x == 0 || node.x == R - 1 || node.y == 0 || node.y == C - 1);
    }

    /** 너비 우선 탐색 수행 */
    static String bfs() {
        while(!que.isEmpty()) {
            Node next = que.remove();
            if (isAnswer(next)) return String.valueOf(next.time);

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 미로의 범위를 벗어난 경우
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                
                // 불인 경우
                if (next.type == Type.Fire) {
                    // 이동할 수 없거나 이미 불인 경우
                    if (maze[nx][ny] == '#' || maze[nx][ny] == 'F') continue;
                    maze[nx][ny] = 'F';
                    que.add(new Node(nx, ny, Type.Fire, next.time + 1));
                }
                // 지훈인 경우
                else {
                    // 이동할 수 없는 곳이거나 이미 방문한 경우
                    if (maze[nx][ny] != '.' || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    que.add(new Node(nx, ny, Type.Jihun, next.time + 1));
                }
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 미로 행의 개수 R 입력
        C = Integer.parseInt(st.nextToken()); // 미로 열의 개수 C 입력
        maze = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String s = br.readLine();
            for (int c = 0; c < C; c++) {
                maze[r][c] = s.charAt(c); // 미로 행 입력
                if (maze[r][c] == 'J') {
                    que.add(new Node(r, c, Type.Jihun, 1));
                    maze[r][c] = '.';
                    visited[r][c] = true;
                }
                if (maze[r][c] == 'F') que.add(new Node(r, c, Type.Fire, 1));
            }
        }

        // "IMPOSSIBLE" 또는 미로를 탈출할 수 있는 가장 빠른 탈출시간 출력
        System.out.println(bfs());
    }
}
