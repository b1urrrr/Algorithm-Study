/*
    백준 6593번 : 상범 빌딩
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
*/

import java.io.*;
import java.util.*;

public class 상범_빌딩 {
    static int L, R, C;
    static char[][][] building;
    static int[] dl = {-1, 1, 0, 0, 0, 0};
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 0, -1, 1};
    static Node start;

    static class Node {
        int l;
        int r;
        int c;
        int time;

        public Node(int l, int r, int c, int time) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    /** 너비 우선 탐색 수행 */
    static String bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            Node next = que.remove();
            
            for (int i = 0; i < 6; i++) {
                int nl = next.l + dl[i];
                int nr = next.r + dr[i];
                int nc = next.c + dc[i];

                // 빌딩을 벗어난 경우
                if (nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                // 출구인 경우
                if (building[nl][nr][nc] == 'E') return "Escaped in " + (next.time + 1) + " minute(s).\n";
                // 이미 방문한 장소인 경우
                if (building[nl][nr][nc] != '.') continue;

                building[nl][nr][nc] = 'S';
                que.add(new Node(nl, nr, nc, next.time + 1));
            }
        }

        return "Trapped!\n";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // 상범 빌딩의 층 수 L 입력
            R = Integer.parseInt(st.nextToken()); // 상범 빌딩 한 층의 행 개수 R 입력
            C = Integer.parseInt(st.nextToken()); // 상범 빌딩 한 층의 열 개수 C 입력
            if (L == 0 && R == 0 && C == 0) break;

            building = new char[L][R][C];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String s = br.readLine();
                    for (int c = 0; c < C; c++) {
                        building[l][r][c] = s.charAt(c);
                        if (building[l][r][c] == 'S') start = new Node(l, r, c, 0);
                    }
                }
                br.readLine();
            }

            // 빌딩에 대한 답 출력
            bw.write(bfs());
        }

        bw.flush();
    }
}
