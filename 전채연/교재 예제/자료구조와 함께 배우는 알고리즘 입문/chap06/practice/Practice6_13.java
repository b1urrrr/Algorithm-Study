package chap06.practice;

import java.util.Scanner;

public class Practice6_13 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        if (right - left < 9) {
            for (int i = left + 1; i <= right; i++) {
                int tmp = a[i];
                int j;
                for (j = i; j > left && a[j - 1] > tmp; j--) {
                    a[j] = a[j - 1];
                }
                a[j] = tmp;
            }
            return;
        }

        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2]; // pivot

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while(pl <= pr);

        if (pr - left < right - pl) {
            if (left < pr) quickSort(a, left, pr);
            if (pl < right) quickSort(a, pl, right);
        } else {
            if (pl < right) quickSort(a, pl, right);
            if (left < pr) quickSort(a, left, pr);
        }
    }

    static void quickSort2(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int pivot = a[(left + right) / 2];

            if (right - left < 9) {
                for (int i = left + 1; i <= right; i++) {
                    int tmp = a[i];
                    int j;
                    for (j = i; j > left && a[j - 1] > tmp; j--) {
                        a[j] = a[j - 1];
                    }
                    a[j] = tmp;
                }
                continue;
            }

            do {
                while (a[pl] < pivot) pl++;
                while (a[pr] > pivot) pr--;
                if (pl <= pr) swap(a, pl++, pr--);
            } while (pl <= pr);

            if (pr - left < pl - right) {
                if (left < pr) {
                    lstack.push(left);
                    rstack.push(pr);
                }
        
                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                }
            } else {
                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                }

                if (left < pr) {
                    lstack.push(left);
                    rstack.push(pr);
                }
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

        // quickSort(x, 0, nx - 1);
        quickSort2(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.printf("x[%d] = %d\n", i, x[i]);
        }
    }   
}
