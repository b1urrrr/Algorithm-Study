package chap06.practice;

import java.util.Scanner;

public class Practice6_9 {
    static int count = 0;

    static void shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }
                a[j + h] = tmp;
                count++;
            }
        }
    }

    static void shellSort2(int[] a, int n) {
        int h;
        // h의 초깃값 설정
        for (h = 1; h < n / 9; h = h * 3 + 1) ;

        for ( ; h > 0; h /= 3)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }
                a[j + h] = tmp;
                count++;
            }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d] : ", i);
            x[i] = stdIn.nextInt();
        }

        // shellSort(x, nx);
        shellSort2(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d] = %d\n", i, x[i]);
        }

        System.out.printf("요소의 이동 횟수 : %d", count);

        stdIn.close();
    }
}
