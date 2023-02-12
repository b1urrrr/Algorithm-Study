package chap06.practice;

import java.util.Scanner;

public class Practice6_5 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n) {
        int start = 0;
        int end = n - 1;
        int turn = 1;
        while (start < end) {
            if (turn % 2 == 1) {
                for (int i = end; i > start; i--) {
                    if (a[i - 1] > a[i])
                        swap(a, i - 1, i);
                }
                start++;
            } else {
                for (int i = start; i < end; i++) {
                    if (a[i] > a[i + 1])
                        swap(a, i, i + 1);
                }
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("양방향 버블 정렬");
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
