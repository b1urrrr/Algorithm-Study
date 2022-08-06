import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class 영역_구하기 {
    static int M, N;
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

    static int bfs(Node n) {
        Queue<Node> que = new LinkedList<>();
        que.add(n);
        // 시작 노드 방문 처리
        paper[n.x][n.y] = -1;

        int area = 1;
        while (!que.isEmpty()) {
            Node node = que.remove();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 모눈종이의 범위를 넘어선 경우
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                // 이미 방문했거나 직사각형이 존재하는 영역인 경우
                if (paper[nx][ny] != 0) continue;
                
                area++;
                que.add(new Node(nx, ny));
                paper[nx][ny] = -1;
            }        
        }

        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        paper = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = Math.min(x1, x2); x < Math.max(x1, x2); x++) {
                for (int y = Math.min(y1, y2); y < Math.max(y1, y2); y++) {
                    paper[y][x] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> area = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i][j] == 0) {
                    count++;
                    area.add(bfs(new Node(i, j)));
                }
            }
        }

        Collections.sort(area);
        System.out.println(count);
        for (int i = 0; i < area.size(); i++) {
            System.out.print(area.get(i) + " ");
        }
        System.out.println();
    }
}
