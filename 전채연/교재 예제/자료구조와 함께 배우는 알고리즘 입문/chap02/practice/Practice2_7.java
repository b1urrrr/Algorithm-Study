package chap02.practice;
import java.util.Scanner;

public class Practice2_7 {
    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int remainder = -1;

        do {
            if (remainder == -1) System.out.printf(" %d |%10d\n", r, x);
            else System.out.printf("%2d |%10d  ··· %d\n", r, x, remainder);
            System.out.println("   + ----------");
            remainder = x % r;
            d[digits++] = dchar.charAt(remainder);
            x /= r;
        } while (x != 0);
        System.out.printf("             0  ··· %d\n", remainder);

        char[] reverse = new char[digits];
        for (int i = 0; i < digits; i++) {
            reverse[i] = d[digits - i - 1];
        }

        for (int i = 0; i < digits; i++) {
            d[i] = reverse[i];
        }

        return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int decimal;
        int divide;
        char[] number = new char[10];

        System.out.println("10진수를 기수 변환합니다.");
        do {
            System.out.print("변환하는 음이 아닌 정수 : ");
            decimal = stdIn.nextInt();
        } while (decimal < 0);

        do {
            System.out.print("어떤 정수로 변환할까요?(2-36) : ");
            divide = stdIn.nextInt();
        } while (divide < 2 || divide > 36);

        System.out.println();
        int digits = cardConv(decimal, divide, number);
        System.out.printf("%d진수로 ", divide);
        for (int i = 0; i < digits; i++) {
            System.out.print(number[i]);
        }
        System.out.println("입니다.");

        stdIn.close();
    }
}
