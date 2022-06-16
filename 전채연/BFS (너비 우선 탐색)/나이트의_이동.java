/*
    백준 7562번 : 나이트의 이동
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 나이트의_이동 {
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int size, Node start, Node end) {
        int[][] board = new int[size][size];
        Queue<Node> que = new LinkedList<>();
        que.add(start);
        board[start.x][start.y] = 1;

        while (!que.isEmpty()) {
            Node next = que.remove();

            for (int i = 0; i < 8; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 보드 범위를 벗어난 경우
                if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                // 이미 방문한 노드인 경우 
                if (board[nx][ny] > 0) continue;

                que.add(new Node(nx, ny));
                board[nx][ny] = board[next.x][next.y] + 1;
            }
        }
        return board[end.x][end.y] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int I = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            System.out.println(bfs(I, start, end));
        }
    }
}
