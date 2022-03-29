package 연습문제;

import java.util.Scanner;

public class q7 {
    // 단순 삽입 정렬 (a[0]를 보초로 삼음)
    static void insertionSort(int[] a, int n) {
        for (int i = 2; i < n; i++) {
            int tmp = a[0] = a[i];
            int j = i;
            for (; a[j-1] > tmp; j--)
                a[j] = a[j-1];
            if (j > 0)
                a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx+1];

        for (int i = 1; i < nx+1; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx); // 버블 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 1; i < nx+1; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
