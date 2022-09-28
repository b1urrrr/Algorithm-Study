/*
    백준 14888번 : 연산자 끼워넣기
    - 문제 유형 : 백트래킹, 브루트 포스
*/

import java.io.*;
import java.util.*;

public class 연산자_끼워넣기 {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, number;
    static int[] numbers;
    static int[] operator = new int[4];

    static void backtracking(int depth) {
        // N개의 수를 연산에 모두 사용한 경우 결과 갱신 및 백트래킹 종료
        if (depth == N) {
            min = Math.min(min, number);
            max = Math.max(max, number);
            return ;
        }

        // 남은 연산 사용
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                int temp = number;
                switch(i) {
                    case 0: // 덧셈인 경우
                        number += numbers[depth];
                        break;
                    case 1: // 뺄셈인 경우
                        number -= numbers[depth];
                        break;
                    case 2: // 곱셈인 경우
                        number *= numbers[depth];
                        break;
                    case 3: // 나눗셈인 경우
                        number /= numbers[depth];
                        break;
                }
                operator[i]--;
                backtracking(depth + 1);
                operator[i]++;
                number = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 수의 개수 N 입력
        numbers = new int[N];

        // A_1, ..., A_N 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken()); // 정수 입력
        }

        // 연산자 개수 입력
        st = new StringTokenizer(br.readLine());
        operator[0] = Integer.parseInt(st.nextToken()); // 덧셈(+)의 개수 입력
        operator[1] = Integer.parseInt(st.nextToken()); // 뺄셈(-)의 개수 입력
        operator[2] = Integer.parseInt(st.nextToken()); // 곱셈(×)의 개수 입력
        operator[3] = Integer.parseInt(st.nextToken()); // 나눗셈(÷)의 개수 입력

        // 백트래킹 시작
        number = numbers[0];
        backtracking(1);

        // 만들 수 있는 식의 결과의 최댓값 출력
        System.out.println(max);
        // 만들 수 있는 식의 결과의 최솟값 출력
        System.out.println(min);
    }
}
