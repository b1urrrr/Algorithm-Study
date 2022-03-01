package chap02;
import java.util.Scanner;

public class ArrayEqual {
    static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 a의 요솟수 : ");
        int na = stdIn.nextInt();

        int[] a = new int[na];

        for (int i = 0; i < na; i++) {
            System.out.printf("a[%d] : ", i);
            a[i] = stdIn.nextInt();
        }

        System.out.print("배열 b의 요솟수 : ");
        int nb = stdIn.nextInt();

        int[] b = new int[nb];

        for (int i = 0; i < nb; i++) {
            System.out.printf("b[%d] : ", i);
            b[i] = stdIn.nextInt();
        }

        System.out.printf("배열 a와 b는 %s\n", equals(a, b)? "같습니다" : "같지 않습니다.");
    }
}
