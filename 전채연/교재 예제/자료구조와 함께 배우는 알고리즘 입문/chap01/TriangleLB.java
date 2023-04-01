package chap01;
import java.util.Scanner;

public class TriangleLB {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");

        do {
            System.out.print("몇 단 삼각형입니까? : ");
            n = stdIn.nextInt();
        } while (n <= 0);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 공백문자 추가하면 더 정갈하게 출력됨.
                System.out.print("* ");
            }
            System.out.println();
        }

        stdIn.close();
    }
}
