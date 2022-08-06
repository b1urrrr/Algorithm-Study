/*
    백준 1926번 : 그림
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 그림 {
    static int n, m, max = 0;
    static int[][] paper;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 너비 우선 탐색 메서드
    static void bfs(Node node) {
        paper[node.x][node.y] = -1; // 시작 노드 방문 처리
        Queue<Node> que = new LinkedList<>();
        que.add(node);

        int area = 1;
        while (!que.isEmpty()) {
            Node next = que.remove();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 도화지의 범위를 넘어선 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 이미 방문한 영역이거나 비어있는 영역인 경우
                if (paper[nx][ny] != 1) continue;

                area++;
                paper[nx][ny] = -1;
                que.add(new Node(nx, ny));
            }
        }

        // 가장 넓은 그림의 넓이로 초기화
        max = Math.max(max, area);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도화지의 세로 크기 입력
        m = Integer.parseInt(st.nextToken()); // 도화지의 가로 크기 입력
        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken()); // 그림의 정보 입력
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 아직 방문하지 않은 그림의 영역을 발견하면 너비 우선 탐색 실행
                if (paper[i][j] == 1) {
                    count++;
                    bfs(new Node(i, j));
                }
            }
        }

        System.out.println(count); // 그림의 개수 출력
        System.out.println(max); // 가장 넓은 그림의 넓이 출력
    }
}