/*
    백준 11726번 : 2×n 타일링
    - 문제 유형 : 동적 계획법
*/

import java.io.*;

public class _2xn_타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n 입력
        int[] data = new int[n + 3];

        data[1] = 1;
        data[2] = 2;
        for (int i = 3; i <= n; i++) {
            int count = data[i - 1]; // 맨 앞에 2×1 타일 1개를 사용하는 경우
            count += data[i - 2]; // 맨 앞에 1×2 타일 2개를 사용하는 경우
            data[i] = count % 10007; // 2×i 크기의 직사각형을 채우는 방법
        }

        // 2×n 크기의 직사각형을 채우는 방법 출력
        System.out.println(data[n]);
    }
}
