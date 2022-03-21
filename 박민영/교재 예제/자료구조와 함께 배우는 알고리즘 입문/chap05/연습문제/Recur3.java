package 연습문제;

import java.util.Scanner;

public class Recur3 {
    // 비재귀적으로 구현
    static void recur3(int n) {
        String[] str = new String[n+1];
        str[0] = "";
        str[1] = "1";
        for (int i = 2; i <= n; i++) {
            str[i] = str[i-1] + str[i-2] + String.format("%d", i);
        }
        System.out.println(str[n]);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur3(x);
    }
}
