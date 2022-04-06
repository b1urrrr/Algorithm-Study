package chap06.practice;

import java.util.Scanner;

public class Practice6_19 {
    static void fSort(int[] a, int n, int min, int max) {
        int[] f = new int[max - min + 1];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) f[a[i] - min]++;                   // 1단계 : 도수분포표 만들기
        for (int i = 1; i <= max - min; i++) f[i] += f[i - 1];         // 2단계 : 누적도수분포표 만들기
        for (int i = n - 1; i >= 0; i--) b[--f[a[i] - min]] = a[i];    // 3단계 : 목적 배열 만들기
        for (int i = 0; i < n; i++) a[i] = b[i];                       // 4단계 : 배열 복사하기
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.printf("x[%d] : ", i);
                x[i] = stdIn.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        int min = x[0];
        for (int i = 1; i < nx; i++) {
            if (x[i] > max) max = x[i];
            if (x[i] < min) min = x[i];
        }

        fSort(x, nx, min, max);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d] = %d\n", i, x[i]);
        }
    }
}
