package chap13;

import java.io.*;
import java.util.*;

public class Question13_21 {
    static int N, L, R, result = 0;
    static boolean moved;
    static int[][] A;
    static boolean[][] visited;
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

    // 너비 우선 탐색 메서드
    static void bfs(int x, int y) {
        Queue<Node> union = new LinkedList<>();
        int sum = A[x][y];
        int count = 1;

        // 시작 노드 처리
        union.add(new Node(x, y));
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visited[x][y] = true;

        while (!que.isEmpty()) {
            Node n = que.remove();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                // 땅의 범위를 벗어났거나 이미 방문한 나라인 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                // 두 나라의 인구 차이가 L명 미만, R명 초과인 경우
                int dif = Math.abs(A[n.x][n.y] - A[nx][ny]);
                if (dif < L || dif > R) continue;

                union.add(new Node(nx, ny));
                sum += A[nx][ny];
                count++;
                que.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }

        if (union.size() > 1) moved = true;

        // 연합한 나라의 인구 변동 조정
        while (!union.isEmpty()) {
            Node country = union.remove();
            A[country.x][country.y] = sum / count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 땅의 크기 입력
        L = Integer.parseInt(st.nextToken()); // 최소 인구 차이 수 입력
        R = Integer.parseInt(st.nextToken()); // 최대 인구 차이 수 입력
        A = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken()); // r행 c열 나라의 인구수 입력
            }
        }

        while (true) {
            moved = false;
            visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    // 이미 방문한 나라이면 통과
                    if (visited[r][c]) continue;
                    // 너비 우선 탐색 수행
                    bfs(r, c);
                }
            }
            if (moved) result++;
            else break;
        }

        // 결과 출력
        System.out.println(result);
    }
}
