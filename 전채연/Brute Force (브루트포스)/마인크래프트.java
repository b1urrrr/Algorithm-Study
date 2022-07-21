/*
    백준 18111번 : 마인크래프트
    - 문제 유형 : 브루트포스 알고리즘
*/

import java.io.*;
import java.util.StringTokenizer;

public class 마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로 칸의 개수 입력
        int M = Integer.parseInt(st.nextToken()); // 가로 칸의 개수 입력
        int B = Integer.parseInt(st.nextToken()); // 인벤토리에 들어있는 블록의 개수 입력
        int[][] blocks = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken()); // 각 블록의 높이 입력
            }
        }

        int minT = Integer.MAX_VALUE;
        int height = -1;
        // 높이를 h(0 ~ 256)로 만드는 시간 완전 탐색
        for (int h = 0; h <= 256; h++) {
            int time = 0;
            int inventory = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 블록을 쌓아야 하는 경우 (1초 소요)
                    if (h > blocks[i][j]) {
                        time += h - blocks[i][j];
                        inventory -= h - blocks[i][j];
                    }

                    // 블록을 제거해야하는 경우 (2초 소요)
                    else if (h < blocks[i][j]) {
                        time += (blocks[i][j] - h) * 2;
                        inventory += blocks[i][j] - h;
                    }
                }
            }
            // 블록이 부족한 경우 무시
            if (inventory < 0) continue;
            // 시간이 최소값이라면 시간과 높이 대입
            if (time <= minT) {
                minT = time;
                height = h;
            }
        }

        // 땅을 고르는 데 걸리는 시간과 땅의 높이를 출력
        System.out.println(minT + " " + height);
    }
}
