package chap06.practice;

import java.util.Scanner;

public class Practice6_6 {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            int t = 0;
            for (; t < i; t++) System.out.print("   ");
            System.out.print("*  ");
            for (t += 1; t < min; t++) System.out.print("   ");
            System.out.println("+");
            for (t = 0; t < n; t++) System.out.printf("%d  ", a[t]);
            System.out.println();
            swap(a, i, min);
        }
    } 
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("선택 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d] : ", i);
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) System.out.printf("x[%d] = %d\n", i, x[i]);
        
        stdIn.close();
    }
}
