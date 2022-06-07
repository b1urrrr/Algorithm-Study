import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 토마토 {
    static int N, M; // 상자의 세로와 가로 칸의 수
    static int[][] graph; // 토마토가 담긴 상자 그래프
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> que = new LinkedList<>();

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 토마토가 모두 익을 때까지의 최소 날짜를 반환하는 함수
    static int check() {
        int max = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 토마토가 들어있지 않은 칸은 무시
                if (graph[i][j] == -1) continue;
                // 익지 않은 토마토가 들어있는 경우 -1 반환
                if (graph[i][j] == 0) return -1;
                // 상자 안 토마토들이 익은 날짜 중 최대값 저장
                max = Math.max(max, graph[i][j]);
            }
        }
        // 토마토가 모두 익을 때까지의 최소 날짜 반환 (1부터 시작했기 때문에 -1)
        return max - 1;
    }

    // 너비 우선 탐색 함수
    static void bfs() {
        while (!que.isEmpty()) {
            // 큐에 들어있는 칸 꺼내기
            Node n = que.remove();

            // 네 방향으로 인접한 칸 처리
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                // 범위가 상자에서 벗어났는지 확인
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 방문한 날짜와 토마토가 들어있는지 확인
                if (graph[nx][ny] != 0) continue;
                
                // 큐에 추가한 뒤 방문 처리
                que.add(new Node(nx, ny));
                graph[nx][ny] = graph[n.x][n.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 상자 가로 칸 수
        N = Integer.parseInt(st.nextToken()); // 상자 세로 칸 수
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                // 탐색 시작 노드가 여러 개인 경우 미리 모두 큐에 추가해놓기
                if (graph[i][j] == 1) que.add(new Node(i, j));
            }
        }

        // 너비 우선 탐색 시작
        bfs();

        // 토마토가 모두 익을 때까지의 최소 날짜 출력 
        System.out.println(check());
    }
}
