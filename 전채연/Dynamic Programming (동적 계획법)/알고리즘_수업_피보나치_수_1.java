/*
    백준 24416번 : 알고리즘 수업 - 피보나치 수 1
    - 문제 유형 : 동적 계획법
*/

import java.io.*;

public class 알고리즘_수업_피보나치_수_1 {
    static int count1 = 0;
    static int count2 = 0;
    
    // 재귀호출 활용 피보나치 도출 함수
    static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1; // 코드1
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    // 동적 프로그래밍 활용 피보나치 도출 함수
    static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            count2++;
            f[i] = f[i - 1] + f[i - 2]; // 코드2
        }

        return f[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n 입력

        fib(n); // 재귀 함수 호출
        fibonacci(n); // 동적 프로그래밍 함수 호출

        System.out.println(count1 + " " + count2);
    }
}
