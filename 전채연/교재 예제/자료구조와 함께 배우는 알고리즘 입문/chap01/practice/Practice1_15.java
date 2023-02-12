package chap01.practice;
import java.util.Scanner;

public class Practice1_15 {
    static void triangleLB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    static void triangleLU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - i -1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.\n몇 단 삼각형입니까? : ");
        int n = stdIn.nextInt();
        triangleLB(n);
        System.out.println("왼쪽 위가 직각인 이등변 삼각형을 출력합니다.");
        triangleLU(n);
        System.out.println("오른쪽 위가 직각인 이등변 삼각형을 출력합니다.");
        triangleRU(n);
        System.out.println("오른쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
        triangleRB(n);

        stdIn.close();
    }
}
