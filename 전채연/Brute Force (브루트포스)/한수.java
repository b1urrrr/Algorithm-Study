/*
    백준 1065번 : 한수
    - 문제 유형 : 브루트포스 알고리즘
*/


import java.util.Scanner;

public class 한수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(); // 자연수 N 입력
        int count = 0;
        
        // 완전 탐색
        for (int i = 1; i <= number; i++) {
            if (i < 100) {
                count++;
            } else if (i < 1000) {
                int firstNum = i % 10;
                int secondNum = i % 100 / 10;
                int thirdNum = i / 100;
                if (secondNum - firstNum == thirdNum - secondNum) {
                    count++;
                }
            }
        }
        
        // 1보다 크거나 같고, N보다 작거나 같은 한수의 개수 출력
        System.out.print(count);

        sc.close();
    }
}