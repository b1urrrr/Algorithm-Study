/*
    백준 17626번 : Four Squares
    - 문제 유형 : 동적 계획법, 브루트포스
*/

import java.io.*;

public class Four_Squares {
    static final int SIZE = 50001; // 최대값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 자연수 n 입력
        int[] data = new int[SIZE]; // 메모이제이션 배열

        data[1] = 1;

        // 2부터 50000까지의 제곱수의 최소 개수 계산
        for (int i = 2; i < SIZE; i++) {
            int min = i; // 1의 제곱만 i번 반복하는 경우로 초기화
            // 1부터 i의 제곱근 이하의 수까지 반복하며 계산
            for (int j = 1; j <= Math.sqrt(i); j++) {
                int total = i;
                int count = 0;
                total -= j * j;
                count++;
                count += data[total];
                min = Math.min(min, count);
            }
            data[i] = min; // i에 대한 제곱수의 최소 개수 대입
        }

        // num에 대한 제곱수의 최소 개수 출력
        System.out.println(data[num]);
    }
}
