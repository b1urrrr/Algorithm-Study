/*
    백준 9328번 : 열쇠
    - 문제 유형 : 구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 열쇠 {
    static int h, w, result, count;
    static char[][] map;
    static boolean[] keys;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        visited[x][y][count] = true;
        // 시작점이 열쇠인 경우
        if (map[x][y] >= 'a' && map[x][y] <= 'z') {
            if (!keys[map[x][y] - 'a']) count++;
            keys[map[x][y] - 'a'] = true;
            map[x][y] = '.';
        }
        // 시작점이 문서인 경우
        if (map[x][y] == '$') {
            map[x][y] = '.';
            result++;
        }
        que.add(new Node(x, y));

        while (!que.isEmpty()) {
            Node next = que.remove();
            if (map[next.x][next.y] >= 'A' && map[next.x][next.y] <= 'Z') {
                // 열 수 있는 문인 경우
                if (keys[map[next.x][next.y] - 'A']) map[next.x][next.y] = '.';
                // 열 수 없는 문인 경우
                else continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 지도의 범위를 벗어난 경우
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                // 벽인 경우
                if (map[nx][ny] == '*') continue;
                // 이미 방문한 노드인 경우
                if (visited[nx][ny][count]) continue;

                // 열쇠인 경우
                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                    if (!keys[map[nx][ny] - 'a']) count++;
                    keys[map[nx][ny] - 'a'] = true;
                    map[nx][ny] = '.';
                }
                // 문서인 경우
                if (map[nx][ny] == '$') {
                    map[nx][ny] = '.';
                    result++;
                }
                visited[nx][ny][count] = true;
                que.add(new Node(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 T 입력

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken()); // 지도의 높이 h 입력 
            w = Integer.parseInt(st.nextToken()); // 지도의 너비 w 입력
            map = new char[h][w];
            keys = new boolean[26];

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j); // (i, j) 지도의 정보 입력
                }
            }

            count = 0;
            String key = br.readLine(); // 이미 가지고 있는 열쇠 입력
            if (key.charAt(0) != '0') {
                for (int i = 0; i < key.length(); i++) {
                    if (!keys[key.charAt(i) - 'a']) count++;
                    keys[key.charAt(i) - 'a'] = true;
                }
            }

            // 빌딩의 가장자리에서 탐색 시작
            result = 0;
            visited = new boolean[h][w][27];
            while (true) {
                int temp = count;
                for (int i = 0; i < h; i++) {
                    if (map[i][0] != '*' && !visited[i][0][count]) bfs(i, 0);
                    if (map[i][w - 1] != '*' && !visited[i][w - 1][count]) bfs(i, w - 1);
                }
                for (int i = 0; i < w; i++) {
                    if (map[0][i] != '*' && !visited[0][i][count]) bfs(0, i);
                    if (map[h - 1][i] != '*' && !visited[h - 1][i][count]) bfs(h - 1, i);
                }
                if (temp == count) break;
            }

            bw.write(result + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
