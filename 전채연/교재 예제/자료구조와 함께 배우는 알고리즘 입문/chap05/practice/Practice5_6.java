package chap05.practice;

import java.util.Scanner;

public class Practice5_6 {
    static String name(int n) {
        if (n == 1) return "시작";
        if (n == 2) return "중간";
        if (n == 3) return "끝";
        return "잘못된 값";
    }

    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);
        
        System.out.printf("원반[%d]을 %s 기둥에서 %s 기둥으로 옮김\n", no, name(x), name(y));

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);

        stdIn.close();
    }
}
