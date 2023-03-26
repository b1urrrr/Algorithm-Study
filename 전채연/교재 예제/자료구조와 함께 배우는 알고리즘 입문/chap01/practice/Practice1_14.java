package chap01.practice;
import java.util.Scanner;

public class Practice1_14 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("사각형을 출력합니다.\n단 수 : ");
        int n = stdIn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 공백 문자 추가하면 더 정갈하게 출력됨.
                System.out.print("* ");
            }
            System.out.println();
        }

        stdIn.close();
    }
}
