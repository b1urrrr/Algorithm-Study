package chap05.practice;

import java.util.Scanner;

public class Practice5_4 {
    static String s;
    static void recur2(int n) {
        if (n > 0) {
            s += "recur2(" + Integer.toString(n - 2) + "); ";
            recur2(n - 2);
            s += Integer.toString(n) + " ";
            s += "recur2(" + Integer.toString(n - 1) + "); ";
            recur2(n - 1);
            System.out.println("recur2(" + n + ") : " + s);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("인자로 전달할 값 : ");
        int num = stdIn.nextInt();

        recur2(num);
    }
}
