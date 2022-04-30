/*
    백준 14500번 : 테트로미노
    - 문제 유형 : 브루트포스 알고리즘
    - 풀이 유형 : 백트래킹, 브루트포스
*/

import java.io.*;
import java.util.StringTokenizer;

public class 테트로미노 {
    static int n, m, result; // 종이의 높이와 너비, 결과
    static int[][] paper; // 종이의 각 칸에 쓰여진 수
    static boolean[][] visit; // 방문 여부
    // 칸에 대해 변이 연결되어 있는 4가지 경우의 수
    static int[] dx = {0, 0, 1, -1}; 
    static int[] dy = {1, -1, 0, 0};

    // 탐색
    static void dfs(int x, int y, int sum, int depth) {
        // 4개의 칸에 정사각형을 놓았으면 최대값 계산 후 반환
        if (depth > 3) {
            result = Math.max(result, sum);
            return;
        }

        // 변이 연결된 칸 탐색
        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            // 잘못된 좌표이거나 이미 방문한 좌표일 경우 생략
            if (moveX < 0 || moveY < 0 || moveX >= n || moveY >= m || visit[moveX][moveY]) continue;

            visit[moveX][moveY] = true;
            dfs(moveX, moveY, sum + paper[moveX][moveY], depth + 1);
            visit[moveX][moveY] = false;
        }

        // 만족하는 수가 더이상 없으면 백트래킹
    }

    // 'ㅗ'모양에 대해 완전 탐색
    static void exception(int x, int y) {
        // 'ㅗ' 모양인 경우 탐색
        if (y - 1 >= 0 && x - 1 >= 0 && y + 1 < m) {
            int sum = paper[x][y] + paper[x][y - 1] + paper[x - 1][y] + paper[x][y + 1];
            result = Math.max(result, sum);
        }
        // 'ㅏ' 모양인 경우 탐색
        if (x - 1 >= 0 && y + 1 < m && x + 1 < n) {
            int sum = paper[x][y] + paper[x - 1][y] + paper[x][y + 1] + paper[x + 1][y];
            result = Math.max(result, sum);
        }
        // 'ㅜ' 모양인 경우 탐색
        if (y - 1 >= 0 && x + 1 < n && y + 1 < m) {
            int sum = paper[x][y] + paper[x][y - 1] + paper[x + 1][y] + paper[x][y + 1];
            result = Math.max(result, sum);
        }
        // 'ㅓ' 모양인 경우 탐색
        if (x + 1 < n && y - 1 >= 0 && x - 1 >= 0) {
            int sum = paper[x][y] + paper[x + 1][y] + paper[x][y - 1] + paper[x - 1][y];
            result = Math.max(result, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken()); // 종이의 높이 입력
        m = Integer.parseInt(st.nextToken()); // 종이의 너비 입력
        paper = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken()); // 칸에 쓸 숫자 입력
            }
        }

        // 첫 번째로 방문할 칸 완전 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, paper[i][j], 1); // 깊이우선탐색
                visit[i][j] = false;
                exception(i, j); // 'ㅗ' 모양 탐색
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
