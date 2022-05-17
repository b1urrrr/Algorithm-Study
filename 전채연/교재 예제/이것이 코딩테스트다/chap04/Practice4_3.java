package chap04;

import java.io.*;

public class Practice4_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pos = br.readLine();
        int x = pos.charAt(0) - 'a' + 1;
        int y = pos.charAt(1) - '0';

        int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX > 0 && tempX < 9 && tempY > 0 && tempY < 9) count++;
        }

        System.out.println(count);
    }
}
