/*
    백준 1463번 : 1로 만들기
    - 문제 유형 : 동적 계획법
*/

import java.io.*;

public class _1로_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] numbers = new int[num + 1]; // DP 테이블

        // 2부터 num까지 연산 횟수 계산
        for (int i = 2; i <= num; i++) {
            numbers[i] = numbers[i - 1] + 1; // 가장 먼저 1을 빼는 경우의 결과
            if (i % 3 == 0) numbers[i] = Math.min(numbers[i], numbers[i / 3] + 1); // 가장 먼저 3으로 나누는 경우의 결과 (최솟값 저장)
            if (i % 2 == 0) numbers[i] = Math.min(numbers[i], numbers[i / 2] + 1); // 가장 먼저 2로 나누는 경우의 결과 (최솟값 저장)
        }

        // num의 연산 횟수 출력
        System.out.println(numbers[num]);
        br.close();
    }
}
