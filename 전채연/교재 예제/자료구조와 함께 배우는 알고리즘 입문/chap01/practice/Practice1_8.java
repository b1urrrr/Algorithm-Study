package chap01.practice;
import java.util.Scanner;

public class Practice1_8 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("1부터 n까지의 합을 구합니다.\nn의 값 : ");
        int n = stdIn.nextInt();
        int result = 0;

        if (n % 2 == 0) { 
            result = (1 + n) * n / 2;
        } else {
            result = (1 + n) * (n / 2) + (1 + n) / 2;
        }

        System.out.printf("1부터 %d까지의 합 : %d", n, result);

        stdIn.close();
    }
}
