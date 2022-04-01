package chap06.practice;

import java.util.Scanner;

public class Practice6_8 {
    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int tmp = a[i];

            int start = 0;
            int end = i - 1;
            int mid;

            do {
                mid = (start + end) / 2;
                if (a[mid] == tmp) {
                    break;
                } else if (a[mid] < tmp) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } while (start <= end);
            int idx = (start <= end) ? mid + 1 : end + 1;

            for (int j = i; j > idx; j--) {
                a[j] = a[j - 1];
            }
            a[idx] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d] : ", i);
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.printf("x[%d] = %d\n", i, x[i]);
    }
}
