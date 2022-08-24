/*
 * @author Minyeong Park
 * @date 2022.08.21.
 * 팩토리얼 0의 개수
 * 참고 및 출처 : https://st-lab.tistory.com/165
 * 문제 링크 : https://www.acmicpc.net/problem/1676
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        // 뒷자리에 0이 n개 있다는 의미 : 2와 5가 n개씩 짝지어 존재한다
        // 2의 개수가 5의 개수보다 많으므로, 5의 개수에 따라 값이 변화한다고 보면 된다.
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        System.out.println(count);
    }
}