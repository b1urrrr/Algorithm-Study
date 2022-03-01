import java.util.Scanner;

public class q4 {
    static void copy (int[] a, int[] b) {
        for (int i = 0; i < b.length; i++)
            a[i] = b[i];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열b의 요솟수 : ");
        int nb = stdIn.nextInt();

        int[] b = new int[nb];

        for (int i = 0; i < nb; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = stdIn.nextInt();
        }

        int[] a = new int[nb];

        copy(a,b);

        System.out.print("복사된 배열 a의 요소 : ");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
    }
}
