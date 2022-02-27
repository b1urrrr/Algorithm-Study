import java.util.Scanner;

public class q15 {
    static void triangleLB(int n) {      //왼쪽 아래가 직각인 이등변 삼각형
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print('*');
            System.out.println();
        }
    }

    static void triangleLU(int n) {      //왼쪽 위가 직각인 이등변 삼각형
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--)
                System.out.print('*');
            System.out.println();
        }
    }

    static void triangleRU(int n) {      //오른쪽 위가 직각인 이등변 삼각형
        for (int i = n; i >= 1; i--) {
            for (int k = 0; k <= 5 - i; k++)
                System.out.print(" ");
            for (int j = i; j >= 1; j--)
                System.out.print('*');
            System.out.println();
        }
    }

    static void triangleRB(int n) {      //오른쪽 아래가 직각인 이등변 삼각형
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= 5 - i; k++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print('*');
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");

        do {
            System.out.print("몇 단 삼각형입니까? : ");
            n = stdIn.nextInt();
        } while(n <= 0);

        System.out.println("[왼쪽 아래가 직각인 이등변 삼각형]");
        triangleLB(n);
        System.out.println("[왼쪽 위가 직각인 이등변 삼각형]");
        triangleLU(n);
        System.out.println("[오른쪽 위가 직각인 이등변 삼각형]");
        triangleRU(n);
        System.out.println("[오른쪽 아래가 직각인 이등변 삼각형]");
        triangleRB(n);
    }
}
