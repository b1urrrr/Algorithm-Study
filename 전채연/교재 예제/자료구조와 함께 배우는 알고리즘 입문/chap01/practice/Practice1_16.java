package chap01.practice;
import java.util.Scanner;

public class Practice1_16 {
    static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for(int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j < (i - 1) * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("몇 단 피라미드입니까? : ");
        int n = stdIn.nextInt();
        spira(n);

        stdIn.close();
    }
}
