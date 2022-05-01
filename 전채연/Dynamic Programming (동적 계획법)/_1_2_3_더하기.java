/*
    백준 9095번 : 1, 2, 3 더하기
    - 문제 유형 : 동적 계획법
*/

import java.io.*;

public class _1_2_3_더하기 {
    static final int SIZE = 12;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine()); // 테이스케이스 개수 입력
        int[] sum = new int[SIZE]; // 메모이제이션 배열
        
        sum[1] = 1;
        sum[2] = 2;
        sum[3] = 4;
        for (int i = 4; i < SIZE; i++) {
            int count = 0;
            for (int j = 1; j < 4; j++) // 1, 2, 3을 더하는 경우를 각각 계산하여 합함
                count += sum[i - j];
            sum[i] = count;
        }

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine()); // n 입력
            bw.write(sum[n] + "\n"); // n을 1, 2, 3의 합으로 나타내는 방법의 수 출력
        }

        bw.flush();
    }
}
