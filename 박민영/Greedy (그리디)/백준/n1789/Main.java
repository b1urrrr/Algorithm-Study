/*
 * @author Minyeong Park
 * @date 2022.09.07.
 * 수들의 합
 * 원리 참고 : https://www.acmicpc.net/board/view/17063
 * 문제 링크 : https://www.acmicpc.net/problem/1789
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();

        int result = 1;
        long sum = 0;
        while (true) {
            sum += result;
            if (sum > S) {
                break;
            }
            result++;
        }
        System.out.println(result - 1);
    }
}