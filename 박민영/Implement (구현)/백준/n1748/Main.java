/*
 * @author Minyeong Park
 * @date 2022.09.09.
 * 수 이어 쓰기 1
 * 원리 참고 : https://www.acmicpc.net/board/view/90532
 * 문제 링크 : https://www.acmicpc.net/problem/1748
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 0;
        for (int i = 1; i <= n; i *= 10) {
            result += n - i + 1;
            // 일의 자리 수가 있는 수는 N개 (N - 1 + 1)
            // 십의 자리 수가 있는 수는 N - 9개 (N - 10 + 1)
            // 백의 자리 수가 있는 수는 N - 99개 (N - 100 + 1)
            // ...
        }
        System.out.println(result);
    }
}