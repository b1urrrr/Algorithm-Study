package chap06.practice;

import java.util.Scanner;

public class Practice6_3 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;
            System.out.printf("패스%d:\n", i + 1);
            for (int j = n - 1; j > i; j--) {
                for (int t = 0; t < j - 1; t++) {
                    System.out.printf("%d ", a[t]);
                }
                System.out.printf("%d", a[j - 1]);
                if (a[j - 1] > a[j]) {
                    System.out.printf("+%d ", a[j]);
                    swap(a, j - 1, j);
                    exchg++;
                } else {
                    System.out.printf("-%d ", a[j]);
                }
                for (int t = j + 1; t < n; t++) {
                    System.out.printf("%d ", a[t]);
                }
                System.out.println();
            }
            if (exchg == 0) break;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 2)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d] : ", i);
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) System.out.printf("x[%d] = %d\n", i, x[i]);

        stdIn.close();
    }
}
