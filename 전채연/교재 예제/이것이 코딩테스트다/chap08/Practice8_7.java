package chap08;

import java.io.*;

public class Practice8_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tiles = new int[N + 1]; // DP 테이블

        tiles[1] = 1;
        tiles[2] = 3;
        for (int i = 3; i <= N; i++) {
            tiles[i] = tiles[i - 2] * 2 + tiles[i - 1] % 796796;
        }

        System.out.println(tiles[N]);
    }
}
