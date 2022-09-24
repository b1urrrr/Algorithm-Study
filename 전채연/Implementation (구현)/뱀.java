/*
    백준 3190번 : 뱀
    - 문제 유형 : 구현, 시뮬레이션, 큐, 덱
*/

import java.io.*;
import java.util.*;

public class 뱀 {
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 방향 전환 클래스
    static class Turn {
        int sec; // 초
        String dir; // 방향

        public Turn(int sec, String dir) {
            this.sec = sec;
            this.dir = dir;
        }
    }

    // 뱀의 몸 클래스
    static class Snake {
        int x;
        int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 보드의 크기 N 입력
        int K = Integer.parseInt(br.readLine()); // 사과의 개수 K 입력

        board = new int[N][N]; // 보드판 배열
        Queue<Turn> turn = new LinkedList<>();
        Queue<Snake> snake = new LinkedList<>();

        // 사과의 위치 입력
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 사과의 행 위치 입력
            int y = Integer.parseInt(st.nextToken()); // 사과의 열 위치 입력
            board[x - 1][y - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수 L 입력
        
        // 뱀의 방향 변환 정보 입력
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken()); // 방향 변환 시각 입력
            String dir = st.nextToken(); // 방향 입력
            turn.add(new Turn(sec, dir));
        }

        int sec = 0; // 시간
        int dir = 1; // 뱀의 방향
        board[0][0] = 2; // 맨위 맨좌측에 뱀 위치
        Snake head = new Snake(0, 0);
        snake.add(new Snake(0, 0));

        while (true) {
            sec++;

            // 방향을 전환하는 경우
            if (!turn.isEmpty() && turn.peek().sec == sec - 1) {
                switch(turn.remove().dir) {
                    case "D": // 오른쪽으로 방향 변환
                        dir++;
                        break;
                    case "L": // 왼쪽으로 방향 변환
                        dir--;
                        break;
                }
                if (dir == -1) dir = 3;
                else if (dir == 4) dir = 0;
            }

            // 앞으로 이동
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];

            // 보드의 범위를 벗어나는 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

            // 이동한 칸에 사과가 없는 경우
            if (board[nx][ny] == 0) {
                // 꼬리 제거
                Snake tail = snake.remove();
                board[tail.x][tail.y] = 0;
            }

            // 자기자신의 몸과 부딪히는 경우
            if (board[nx][ny] == 2) break;

            board[nx][ny] = 2;
            snake.add(new Snake(nx, ny));
            head = new Snake(nx, ny);
        }

        // 게임이 몇 초에 끝나는지 출력
        System.out.println(sec);
    }
}