package chap01;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Median {
    static int med3(int a, int b, int c) {
        if (a > b)
            if (b > c)
                return b;
            else if (c > a)
                return a;
            else
                return c;
        else
            if (a > c)
                return a;
            else if (c > b)
                return b;
            else
                return c;
    }
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 중앙값을 구합니다.");
        System.out.print("a의 값 : "); int a = stdIn.nextInt();
        System.out.print("b의 값 : "); int b = stdIn.nextInt();
        System.out.print("c의 값 : "); int c = stdIn.nextInt();

        System.out.println("중앙값은 " + med3(a, b, c) + "입니다.");
    }
}
