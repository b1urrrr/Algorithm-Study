/*
    백준 2665번 : 미로만들기
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 데이크스트라
    - 풀이 유형 : 0-1 BFS (0-1 너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 미로만들기 {
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        Deque<Node> dq = new LinkedList<>();
        dq.add(new Node(0, 0));
        graph[0][0] = 2;

        while(!dq.isEmpty()) {
            Node next = dq.remove();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 그래프 범위를 벗어난 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                // 이미 처리한 방인 경우
                if (graph[nx][ny] > 1) continue;

                // 흰 방인 경우
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[next.x][next.y];
                    dq.addFirst(new Node(nx, ny));
                }
                // 검은 방인 경우
                else {
                    graph[nx][ny] = graph[next.x][next.y] + 1;
                    dq.addLast(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 한 줄에 들어가는 방의 수 n 입력
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j) - '0'; // 방의 색 입력 (0: 검은 방, 1: 흰 방)
            }
        }

        bfs();

        // 흰 방으로 바꾸어야 할 최소의 검은 방의 수 출력
        System.out.println(graph[n - 1][n - 1] - 2);
    }
}
