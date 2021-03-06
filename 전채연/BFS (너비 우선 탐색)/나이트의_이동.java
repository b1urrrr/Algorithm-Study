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

    // 너비 우선 탐색 메서드
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
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 입력

        for (int i = 0; i < testCase; i++) {
            int I = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 나이트가 현재 있는 칸 입력
            st = new StringTokenizer(br.readLine());
            Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 나이트가 이동하려는 칸 입력

            // 나이트가 최소 몇 번만에 이동할 수 있는지 출력
            System.out.println(bfs(I, start, end));
        }
    }
}
