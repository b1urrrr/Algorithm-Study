/*
    백준 5427번 : 불
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
*/

import java.io.*;
import java.util.*;

public class 불 {
    static char[][] maze;
    static boolean[][] visited;
    static int w, h;
    static PriorityQueue<Node> que;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static enum Type {
        Sanggeun, Fire
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
        return node.type == Type.Sanggeun && (node.x == 0 || node.x == h - 1 || node.y == 0 || node.y == w - 1);
    }

    /** 너비 우선 탐색 수행 */
    static String bfs() {
        while(!que.isEmpty()) {
            Node next = que.remove();
            if (isAnswer(next)) return String.valueOf(next.time);

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 지도의 범위를 벗어난 경우
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                
                // 불인 경우
                if (next.type == Type.Fire) {
                    // 이동할 수 없거나 이미 불인 경우
                    if (maze[nx][ny] == '#' || maze[nx][ny] == '*') continue;
                    maze[nx][ny] = '*';
                    que.add(new Node(nx, ny, Type.Fire, next.time + 1));
                }
                // 상근인 경우
                else {
                    // 이동할 수 없는 곳이거나 이미 방문한 경우
                    if (maze[nx][ny] != '.' || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    que.add(new Node(nx, ny, Type.Sanggeun, next.time + 1));
                }
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

            for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 빌딩 지도의 너비 w 입력
            h = Integer.parseInt(st.nextToken()); // 빌딩 지도의 높이 h 입력
            maze = new char[h][w];
            visited = new boolean[h][w];
            que = new PriorityQueue<>();

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    maze[i][j] = s.charAt(j); // 빌딩의 지도 입력
                    if (maze[i][j] == '*') {
                        que.add(new Node(i, j, Type.Fire, 1));
                        continue;
                    }
                    if (maze[i][j] == '@') {
                        que.add(new Node(i, j, Type.Sanggeun, 1));
                        maze[i][j] = '.';
                        visited[i][j] = true;
                    }
                }
            }

            // "IMPOSSIBLE" 또는 빌딩을 탈출하는 데 가장 빠른 시간 출력
            System.out.println(bfs());
        }
    }
}
