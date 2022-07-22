/*
    백준 2133번 : 타일 채우기
    - 문제 유형 : 동적 계획법
*/

import java.io.*;

public class 타일_채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 타일의 너비 입력
        // 0 = 다 채움, 1 = 위 한 칸, 2 = 아래 한 칸, 3 = 위·중간 두 칸, 4 = 중간·아래 두 칸
        int[][] tiles = new int[N + 1][5];
        
        // N이 1인 경우 0 출력 후 종료
        if (N == 1) {
            System.out.println(0);
            return;
        }

        // 너비가 1인 경우의 값으로 초기화
        tiles[1][1] = 1; tiles[1][2] = 1;
        // 너비가 2인 경우의 값으로 초기화
        tiles[2][0] = 3; tiles[2][3] = 1; tiles[2][4] = 1;
        for (int i = 3; i <= N; i++) {
            // 다 채우는 경우
            tiles[i][0] = tiles[i - 2][0] + tiles[i - 1][1] + tiles[i - 1][2];

            // 위에 한 칸이 삐져나오는 경우
            tiles[i][1] = tiles[i - 1][0] + tiles[i - 1][4];

            // 아래 한 칸이 삐져나오는 경우
            tiles[i][2] = tiles[i - 1][0] + tiles[i - 1][3];
            
            // 위·중간 두 칸이 삐져나오는 경우
            tiles[i][3] = tiles[i - 1][2];

            // 중간·아래 두 칸이 삐져나오는 경우
            tiles[i][4] = tiles[i - 1][1];
        }

        // 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수 출력
        System.out.println(tiles[N][0]);
    }
}