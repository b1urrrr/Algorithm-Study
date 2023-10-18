/*
    백준 3184번 : 양
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 양 {
    static int R, C, sheep = 0, wolf = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        int sheepCount = 0, wolfCount = 0;
        Queue<Node> que = new LinkedList<>();
        if (map[x][y] == 'o') sheepCount++;
        else if (map[x][y] == 'v') wolfCount++;
        map[x][y] = '#';
        que.add(new Node(x, y));

        while (!que.isEmpty()) {
            Node next = que.remove();

            A : for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                switch(map[nx][ny]) {
                    case '#' : 
                        continue A;
                    case 'o' : 
                        sheepCount++;
                        break;
                    case 'v' : 
                        wolfCount++;
                        break;
                }

                map[nx][ny] = '#';
                que.add(new Node(nx, ny));
            }
        }

        if (sheepCount > wolfCount) sheep += sheepCount;
        else wolf += wolfCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '.') bfs(i, j);
            }
        }

        System.out.println(sheep + " " + wolf);
    }
}
