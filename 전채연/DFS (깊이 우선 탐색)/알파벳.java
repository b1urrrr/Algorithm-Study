/*
    백준 1987번 : 알파벳
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;

public class 알파벳 {
    static int R, C, max = -1;
    static char[][] board;
    static boolean[][] visited;                    // 방문 여부 기록 배열
    static boolean[] alphabet = new boolean[26];   // 알파벳 기록 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 깊이 우선 탐색 메서드
    static void dfs(int x, int y, int count) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 보드 범위를 벗어난 경우
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            // 이미 방문한 노드인 경우
            if (visited[nx][ny] == true) continue;
            // 이미 지나온 알파벳인 경우
            if (alphabet[board[nx][ny] - 'A'] == true) continue;

            visited[nx][ny] = true;
            alphabet[board[nx][ny] - 'A'] = true;
            dfs(nx, ny, count + 1);
        }
        // 말이 지나온 칸 수의 최대값 기록
        max = Math.max(max, count);
        visited[x][y] = false;
        alphabet[board[x][y] - 'A'] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 세로 칸 입력
        C = Integer.parseInt(st.nextToken()); // 가로 칸 입력
        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j); // 보드의 알파벳 입력
            }
        }

        // 시작 노드 방문 처리
        visited[0][0] = true;
        alphabet[board[0][0] - 'A'] = true;
        dfs(0, 0, 1); // 깊이 우선 탐색 실행


        // 말이 지날 수 있는 최대의 칸 수 출력
        System.out.println(max);
    }
}
