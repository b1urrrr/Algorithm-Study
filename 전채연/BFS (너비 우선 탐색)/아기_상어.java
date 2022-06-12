/*
    백준 16236번 : 아기 상어
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 아기_상어 {
    static int n, shark = 2, fish = 0, eat = 0; // 공간 한 변의 길이, 상어의 크기, 물고기 수, 크기 증가를 위해 물고기를 먹은 횟수
    static int[][] graph;
    static Queue<Node> que = new LinkedList<>();
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        } 
    }

    // 아기 상어가 먹을 수 있는 물고기가 남았는지 확인하는 메서드
    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] > 0 && graph[i][j] < shark) return true;
            }
        }
        return false;
    }

    // 너비 우선 탐색 메서드
    static int bfs() {
        int resultX = -1, resultY = -1;
        int visit[][] = new int[n][n];
        boolean isStart = true;

        while (!que.isEmpty()) {
            Node node = que.remove();
            if (isStart) {
                visit[node.x][node.y] = 1;
                isStart = false;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 공간의 범위를 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                // 방문한 적 있는 경우
                if (visit[nx][ny] > 0) continue;
                // 큰 물고기를 만난 경우 무시
                if (graph[nx][ny] > shark) continue;
                // 빈 공간이거나 크기가 같은 물고기가 있는 경우 해당 칸으로 이동
                else if (graph[nx][ny] == 0 || graph[nx][ny] == shark) {
                    visit[nx][ny] = visit[node.x][node.y] + 1;
                    if (resultX == -1) que.add(new Node(nx, ny));
                }
                // 작은 물고기를 만나서 잡아먹는 경우
                else {
                    visit[nx][ny] = visit[node.x][node.y] + 1;
                    if (resultX > -1 && visit[resultX][resultY] < visit[nx][ny]) continue;
                    if (resultX == -1 || resultX > nx || (resultX == nx && resultY > ny)) {
                        resultX = nx;
                        resultY = ny;
                    }
                }
            }
        }
        // 상어의 크기가 커지는 경우
        if (++eat == shark) {
            shark++;
            eat = 0;
        }
        // 먹을 수 있는 물고기가 없는 경우
        if (resultX == -1) return -1;
        graph[resultX][resultY] = 0;
        que.clear();
        que.add(new Node(resultX, resultY));
        return visit[resultX][resultY] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) {
                    graph[i][j] = 0;
                    que.add(new Node(i, j));
                }
            }
        }

        int sec = 0;
        while (check()) {
            int result = bfs();
            if (result == -1) break;
            sec += result;
        }

        // 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간 출력
        System.out.println(sec);
    }
}
