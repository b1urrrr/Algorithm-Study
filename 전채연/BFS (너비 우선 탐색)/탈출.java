/*
    백준 3055번 : 탈출
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 탈출 {
    static char[][] map;
    static Queue<Node> waterQue = new LinkedList<>();
    static Queue<Node> hedgehogQue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R, C;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /** 티떱숲 너비 우선 탐색 함수 */
    static int bfs() {
        int[][] visited = new int[R][C];
        
        while (!hedgehogQue.isEmpty()) {
            // 물 탐색 수행
            int waterLen = waterQue.size();
            for (int w = 0; w < waterLen; w++) {
                Node nextWater = waterQue.remove();
                for (int i = 0; i < 4; i++) {
                    int wx = nextWater.x + dx[i];
                    int wy = nextWater.y + dy[i];

                    // 지도 크기를 벗어난 경우
                    if (wx < 0 || wx >= R || wy < 0 || wy >= C) continue;
                    // 고슴도치를 만나지 않고 비어있지도 않은 경우
                    if (map[wx][wy] != 'S' && map[wx][wy] != '.') continue;

                    map[wx][wy] = '*'; // 물 확장
                    waterQue.add(new Node(wx, wy));
                }
            }

            // 고슴도치 탐색 수행
            int hedgehogLen = hedgehogQue.size();
            for (int h = 0; h < hedgehogLen; h++) {
                Node nextHedgehog = hedgehogQue.remove();
                for (int i = 0; i < 4; i++) {
                    int hx = nextHedgehog.x + dx[i];
                    int hy = nextHedgehog.y + dy[i];

                    // 지도 크기를 벗어난 경우
                    if (hx < 0 || hx >= R || hy < 0 || hy >= C) continue;
                    // 비버를 만난 경우 정답 반환
                    if (map[hx][hy] == 'D') return visited[nextHedgehog.x][nextHedgehog.y] + 1;
                    // 비어있지 않은 경우
                    if (map[hx][hy] != '.') continue;

                    map[hx][hy] = 'S'; // 고슴도치 이동
                    visited[hx][hy] = visited[nextHedgehog.x][nextHedgehog.y] + 1;
                    hedgehogQue.add(new Node(hx, hy));
                }
            }
        }

        // 고슴도치가 비버의 굴로 이동할 수 없는 경우
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 지도의 행 R 입력
        C = Integer.parseInt(st.nextToken()); // 지도의 열 C 입력
        map = new char[R][C];

        // 티떱숲의 지도 입력
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j); // 지도 i행 j열 표시 (. : 빈 공간, * : 물, X : 돌, D : 비버, S : 고슴도치)
                
                // 물 또는 고슴도치인 경우 큐에 추가
                if (map[i][j] == '*') waterQue.add(new Node(i, j));
                if (map[i][j] == 'S') hedgehogQue.add(new Node(i, j));
            }
        }

        // 너비 우선 탐색 수행
        int result = bfs();

        // 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간 출력
        if (result == -1) System.out.println("KAKTUS");
        else System.out.println(result);
    }
}
