/*
 * @author Minyeong Park
 * @date 2023.05.14.
 * 별 찍기 - 7
 * 문제 링크 : https://www.acmicpc.net/problem/2444
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 0; i < 2 * n - 1; i++) {
            sb.append("*");
        }
        sb.append("\n");

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < n - i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}