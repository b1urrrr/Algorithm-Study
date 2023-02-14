/*
    백준 4485번 : 녹색 옷 입은 애가 젤다지?
    - 문제 유형 : 그래프 이론, 데이크스트라
*/

import java.io.*;
import java.util.*;

public class 녹색_옷_입은_애가_젤다지 {
    static final int INF = (int) 1e9;
    static int[][] graph;
    static int[][] spt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int rupee;

        Node(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        @Override
        public int compareTo(Node other) {
            if (this.rupee < other.rupee) return -1;
            return 1;
        }
    }

    /** 최소 금액 탐색 함수 */
    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, graph[0][0]));
        spt[0][0] = graph[0][0];

        while (!pq.isEmpty()) {
            Node next = pq.remove();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                // 동굴 크기를 벗어난 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                // 이미 처리한 칸인 경우
                if (spt[nx][ny] < graph[nx][ny]) continue;

                if (spt[next.x][next.y] + graph[nx][ny] < spt[nx][ny]) {
                    spt[nx][ny] = spt[next.x][next.y] + graph[nx][ny];
                    pq.add(new Node(nx, ny, spt[nx][ny]));
                }
            }
        }

        return spt[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;

        while (true) {
            N = Integer.parseInt(br.readLine()); // 동굴의 크기 N 입력
            if (N == 0) break;

            graph = new int[N][N];
            spt = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    spt[i][j] = INF;
                    graph[i][j] = Integer.parseInt(st.nextToken()); // 도둑루피의 크기 입력
                }
            }

            // 다익스트라 수행
            int result = dijkstra();

            // 링크가 잃을 수밖에 없는 최소 금액 출력
            System.out.printf("Problem %d: %d\n", count++, result);
        }
    }
}