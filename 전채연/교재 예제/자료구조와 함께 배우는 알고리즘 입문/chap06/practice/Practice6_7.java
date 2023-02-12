package chap06.practice;

import java.util.Scanner;

public class Practice6_7 {
    static void insertionSort(int[] a, int n) {
        for (int i = 2; i < n; i++) {
            int j;
            a[0] = a[i];
            for (j = i; a[j - 1] > a[0]; j--) {
                a [j] = a[j - 1];
            }
            a[j] = a[0];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        nx++;
        int[] x = new int[nx];

        for (int i = 1; i < nx; i++) {
            System.out.printf("x[%d] : ", i);
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 1; i < nx; i++) System.out.printf("x[%d] = %d\n", i, x[i]);

        stdIn.close();
    }
}
