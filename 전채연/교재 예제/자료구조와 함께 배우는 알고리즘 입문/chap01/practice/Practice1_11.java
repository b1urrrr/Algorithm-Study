package chap01.practice;
import java.util.Scanner;

public class Practice1_11 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("양의 정수를 입력하세요 : "); int num = stdIn.nextInt();
        int digits = 1;
        int divide = 10;
        
        while (num / divide != 0) {
            digits++;
            divide *= 10;
        }

        System.out.printf("그 수는 %d자리입니다.\n", digits);

        stdIn.close();
    }
}
