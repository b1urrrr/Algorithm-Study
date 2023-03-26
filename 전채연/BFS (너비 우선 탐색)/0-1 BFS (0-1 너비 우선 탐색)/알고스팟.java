/*
    백준 1261번 : 알고스팟
    - 문제 유형 : 그래프 이론, 그래프 탐색, 데이크스트라, 0-1 너비 우선 탐색
    - 풀이 유형 : 0-1 BFS (0-1 너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 알고스팟 {
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    static class Node {
        int x;
        int y;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /** 벽 부수는 최소 횟수 탐색 함수 */
    static void bfs() {
        Deque<Node> dq = new LinkedList<>();
        dq.add(new Node(0, 0));
        graph[0][0] = 2;

        while(!dq.isEmpty()) {
            Node next = dq.remove();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 미로 크기를 벗어난 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 이미 방문한 칸인 경우
                if (graph[nx][ny] > 1) continue;
                
                // 벽인 경우
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[next.x][next.y] + 1;
                    dq.addLast(new Node(nx, ny));
                } 
                // 빈 방인 경우
                else {
                    graph[nx][ny] = graph[next.x][next.y];
                    dq.addFirst(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 미로의 가로 크기 M 입력
        N = Integer.parseInt(st.nextToken()); // 미로의 세로 크기 N 입력
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j) - '0'; // 미로의 상태 입력 (0: 빈 방, 1: 벽)
            }
        }

        bfs();

        // 알고스팟 운영진이 (N, M)으로 이동하기 위해 벽을 최소 몇 개 부수어야 하는지 출력
        System.out.println(graph[N - 1][M - 1] - 2);
    }
}
