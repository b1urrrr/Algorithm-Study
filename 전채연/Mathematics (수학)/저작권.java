/*
    백준 2914번 : 저작권
    - 문제 유형 : 수학, 사칙연산, 구현
*/

import java.util.Scanner;

public class 저작권 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int songs = stdIn.nextInt();
        int average = stdIn.nextInt();
        
        System.out.println(songs * (average - 1) + 1);
    }
}