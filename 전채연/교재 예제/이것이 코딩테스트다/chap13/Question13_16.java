package chap13;

import java.io.*;
import java.util.*;

public class Question13_16 {
    static class Node {
        int x;
        int y;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, max = -1, safe; // 세로 크기 N, 가로 크기 M, 안전 영역의 최대 크기 max, 안전 영역의 개수
    static int[][] mapB; // 지도의 모양
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 너비 우선 탐색 메서드
    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        mapB[x][y] = -1;

        while (!que.isEmpty()) {
            Node node = que.remove();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 지도의 범위를 벗어난 경우 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 이미 방문한 영역이거나 벽인 경우 무시
                if (mapB[nx][ny] == -1 || mapB[nx][ny] == 1) continue;

                if (mapB[nx][ny] == 0) safe--;
                mapB[nx][ny] = -1;
                que.add(new Node(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기 N 입력
        M = Integer.parseInt(st.nextToken()); // 가로 크기 M 입력
        int[][] map = new int[N][M];
        ArrayList<Node> empty = new ArrayList<>();
        ArrayList<Node> virus = new ArrayList<>();

        // 지도의 모양 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 빈 칸인 경우
                if (map[i][j] == 0) empty.add(new Node(i, j));
                // 바이러스인 경우
                else if (map[i][j] == 2) virus.add(new Node(i, j)); 
            }
        }

        // 벽 3개 완전 탐색으로 선택
        for (int a = 0; a < empty.size() - 2; a++) {
            for (int b = a + 1; b < empty.size() - 1; b++) {
                for (int c = b + 1; c < empty.size(); c++) {
                    // 지도 복제
                    mapB = new int[N][M];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            mapB[i][j] = map[i][j];
                        }
                    }

                    // 벽 3개 세우기
                    mapB[empty.get(a).x][empty.get(a).y] = 1;
                    mapB[empty.get(b).x][empty.get(b).y] = 1;
                    mapB[empty.get(c).x][empty.get(c).y] = 1;
                    safe = empty.size() - 3;

                    // 아직 탐색하지 않은 바이러스의 모든 위치에 대해 너비 우선 탐색 수행
                    for (int i = 0; i < virus.size(); i++) {
                        if (mapB[virus.get(i).x][virus.get(i).y] == 2) bfs(virus.get(i).x, virus.get(i).y);
                    }

                    // 안전 영역의 최대 크기 갱신
                    max = Math.max(max, safe);
                }
            }
        }

        // 안전 영역의 최대 크기 출력
        System.out.println(max);
    }
}
