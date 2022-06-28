package chap08;

import java.io.*;

public class Practice8_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] memo = new int[x + 1]; // 메모이제이션 배열

        for (int i = 2; i <= x; i++) {
            // 1을 빼는 경우
            memo[i] = memo[i - 1] + 1;
            // 5로 나누는 경우
            if (i % 5 == 0) memo[i] = Math.min(memo[i], memo[i / 5] + 1);
            // 3으로 나누는 경우
            if (i % 3 == 0) memo[i] = Math.min(memo[i], memo[i / 3] + 1);
            // 2로 나누는 경우
            if (i % 2 == 0) memo[i] = Math.min(memo[i], memo[i / 2] + 1);
        }

        System.out.println(memo[x]);
    }
}
