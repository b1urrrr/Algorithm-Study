/*
    백준 17836번 : 공주님을 구해라!
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
*/

import java.io.*;
import java.util.*;

public class 공주님을_구해라 {
    static int N, M, T;
    static int[][] castle;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int gram;
        int time;

        public Node(int x, int y, int gram, int time) {
            this.x = x;
            this.y = y;
            this.gram = gram;
            this.time = time;
        }
    }

    static String bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!que.isEmpty()) {
            Node next = que.remove();
            if (next.time >= T) break;

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 성에서 벗어난 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 이미 방문한 노드인 경우
                if (visited[nx][ny][next.gram]) continue;
                // 그람을 획득하지 못했으며 벽인 경우
                if (next.gram == 0 && castle[nx][ny] == 1) continue;
                // 공주인 경우
                if (nx == N - 1 && ny == M - 1) return String.valueOf(next.time + 1);

                int isGram = next.gram == 1 || castle[nx][ny] == 2 ? 1 : 0;
                visited[nx][ny][isGram] = true;
                que.add(new Node(nx, ny, isGram, next.time + 1));
            }
        }

        return "Fail";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 성의 높이 N 입력
        M = Integer.parseInt(st.nextToken()); // 성의 너비 M 입력
        T = Integer.parseInt(st.nextToken()); // 제한 시간 T 입력
        castle = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken()); // 성의 구조 입력
            }
        }

        // 공주에게 도달할 수 있는 최단 시간 출력
        System.out.println(bfs());
    }
}
