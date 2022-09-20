package chap13;

import java.io.*;
import java.util.*;

public class Question13_17 {
    static int N, K, S; // 시험관의 크기 N, 바이러스의 종류 K, 계산 시간 S
    static int[][] tube; // 시험관 배열
    static PriorityQueue<Virus> virus = new PriorityQueue<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Virus implements Comparable<Virus> {
        int x;
        int y;
        int type;

        Virus(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public int compareTo(Virus other) {
            return Integer.compare(this.type, other.type);
        } 
    }

    // 너비 우선 탐색 메서드
    static void bfs() {
        int sec = 0;
        PriorityQueue<Virus> next = new PriorityQueue<>();

        while(!virus.isEmpty()) {
            Virus v = virus.remove();
            // 계산할 시간에 도달한 경우
            if (S == sec) return;

            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                // 시험관의 범위를 벗어난 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                // 바이러스가 이미 존재하는 경우
                if (tube[nx][ny] > 0) continue;

                tube[nx][ny] = v.type;
                next.add(new Virus(nx, ny, v.type));
            }

            // 다음 초에 증식할 바이러스들 우선순위 큐에 삽입
            if (virus.isEmpty()) {
                sec++;
                while (!next.isEmpty()) {
                    virus.add(next.remove());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 시험관의 크기 N 입력
        K = Integer.parseInt(st.nextToken()); // 바이러스의 종류 K 입력
        tube = new int[N][N];

        // 시험관의 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken()); // 바이러스의 종류 입력
                if (tube[i][j] > 0) virus.add(new Virus(i, j, tube[i][j]));
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 계산 시간 S 입력
        int X = Integer.parseInt(st.nextToken()); // 계산 위치 X 입력
        int Y = Integer.parseInt(st.nextToken()); // 계산 위치 Y 입력

        // 너비 우선 탐색 수행
        bfs();

        // S초 뒤에 (X,Y)에 존재하는 바이러스의 종류 출력
        System.out.println(tube[X - 1][Y - 1]);
    }
}
