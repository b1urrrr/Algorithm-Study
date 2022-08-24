/*
 * @author Minyeong Park
 * @date 2022.08.24.
 * 돌 게임
 * 문제 링크 : https://www.acmicpc.net/problem/9655
 */

// 다이나믹 프로그래밍 문제인데.. 너무 간단하게 풀었다...

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}