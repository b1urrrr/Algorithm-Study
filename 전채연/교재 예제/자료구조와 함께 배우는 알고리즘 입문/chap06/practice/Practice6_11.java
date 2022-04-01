package chap06.practice;

import java.util.Scanner;

public class Practice6_11 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);
        System.out.printf("push : a[%d] ~ a[%d]\n", left, right);
        System.out.print("Lstack:");
		lstack.dump();
		System.out.print("Rstack:");
		rstack.dump();

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            System.out.printf("pop : a[%d] ~ a[%d]\n", left, right);
            int pivot = a[(left + right) / 2];

            do {
                while (a[pl] < pivot) pl++;
                while (a[pr] > pivot) pr--;
                if (pl <= pr) swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
                System.out.printf("push : a[%d] ~ a[%d]\n", left, right);
                System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
            }
            
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
                System.out.printf("push : a[%d] ~ a[%d]\n", left, right);
                System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d] : ", i);
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d] = %d\n", i, x[i]);
        }
    }
}
