package chap01.practice;
import java.util.Scanner;

public class Practice1_10 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("a의 값 : "); int a = stdIn.nextInt();
        int b;
        while (true){
            System.out.print("b의 값 : "); b = stdIn.nextInt();
            if (a >= b) System.out.println("a보다 큰 값을 입력하세요!");
            else break;
        }
        System.out.println("b - a는 " + (b - a) + "입니다.");
    }
}
