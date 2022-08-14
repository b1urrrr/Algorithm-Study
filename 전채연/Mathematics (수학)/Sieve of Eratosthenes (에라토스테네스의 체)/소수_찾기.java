/*
    백준 1978번 : 소수 찾기
    - 문제 유형 : 수학, 에라토스테네스의 체
*/

import java.util.Scanner;

public class 소수_찾기 {
    public static void main(String[] main) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt(); // 수의 개수 입력
        int count = 0;
        for (int i = 0; i < repeat; i++) {
            int number = sc.nextInt(); // 수 입력
            boolean isPrime = true;
            if (number == 1) continue;
            for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) count++;
        }
        // 소수의 개수 출력
        System.out.print(count);
    }
}