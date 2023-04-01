/*
    백준 1245번 : 농장 관리
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 농장_관리 {
    static int[][] farm;
    static int[] dx = {-1, 1, -1, 1, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 1, -1, 0, 0, -1, 1};
    static int N, M, result = 0;

    static class Node {
        int x;
        int y;
        int height;

        Node(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    /** 격자 너비 우선 탐색 함수 */
    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y, farm[x][y]));
        farm[x][y] = -1;
        result++;

        boolean[] climb = new boolean[501];
        while (!que.isEmpty()) {
            Node next = que.remove();

            for (int i = 0; i < 8; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 격자의 범위를 벗어난 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 이미 방문한 격자인 경우
                if (farm[nx][ny] == -1) continue;
                // 더 높은 격자인 경우
                if (next.height < farm[nx][ny]) {
                    if (!climb[next.height]) climb[next.height] = true;
                    else continue;
                } 
                // 더 낮은 격자인 경우
                if (next.height > farm[nx][ny]) climb[farm[nx][ny]] = true;

                que.add(new Node(nx, ny, farm[nx][ny]));
                farm[nx][ny] = -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 농장 격자의 가로 길이
        M = Integer.parseInt(st.nextToken()); // 농장 격자의 세로 길이
        farm = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken()); // 좌표 (i, j) 격자의 높이 입력
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 아직 방문하지 않은 격자라면 너비 우선 탐색 수행
                if (farm[i][j] != -1) bfs(i, j);
            }
        }

        // 산봉우리의 개수 출력
        System.out.println(result);
    }
}
