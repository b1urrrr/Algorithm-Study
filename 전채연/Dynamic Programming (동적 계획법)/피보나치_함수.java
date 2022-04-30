/*
    백준 1003번 : 피보나치 함수
    - 문제 유형 : 동적 계획법
*/

import java.io.*;
import java.lang.StringBuilder;

public class 피보나치_함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine()); // N 입력
            int[][] fibo = new int[num + 2][2];
            fibo[0][0] = 1; fibo[0][1] = 0; // fibonacci(0) 호출 시 0과 1이 출력되는 횟수 초기화
            fibo[1][0] = 0; fibo[1][1] = 1; // fibonacci(1) 호출 시 0과 1이 출력되는 횟수 초기화

            for (int j = 2; j <= num; j++) {
                // fibonacci(j) 호출 시 0과 1이 출력되는 횟수 계산 : fibonacci(j - 1)와 fibonacci(j - 2)의 값을 합함
                fibo[j][0] = fibo[j -1][0] + fibo[j - 2][0];
                fibo[j][1] = fibo[j -1][1] + fibo[j - 2][1];
            }

            sb.append(fibo[num][0] + " " + fibo[num][1] + "\n"); // 결과 저장
        }
        
        System.out.print(sb); // 결과 출력
    }
}