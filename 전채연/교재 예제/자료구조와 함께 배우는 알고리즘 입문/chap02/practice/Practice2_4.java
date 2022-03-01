package chap02.practice;
import java.util.Scanner;

public class Practice2_4 {
    // Q4
    static void copy(int[] a, int[] b) {
        if (a.length < b.length) {
            System.out.println("배열의 크기가 작습니다.");
            return;
        }
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    // Q5
    static void rcopy(int[] a, int[] b) {
        if (a.length < b.length) {
            System.out.println("배열의 크기가 작습니다.");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = b[b.length - 1 - i];
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열의 요솟수 : ");
        int size = stdIn.nextInt();
        int[] a = new int[size];
        int[] b = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("b[%d] : ", i);
            b[i] = stdIn.nextInt();
        }

        copy(a, b);
        System.out.println("<copy의 결과>");
        for (int i = 0; i < size; i++) {
            System.out.printf("a[%d] = %d\n", i, a[i]);
        }

        rcopy(a, b);
        System.out.println("<rcopy의 결과>");
        for (int i = 0; i < size; i++) {
            System.out.printf("a[%d] = %d\n", i, a[i]);
        }

    }
}
