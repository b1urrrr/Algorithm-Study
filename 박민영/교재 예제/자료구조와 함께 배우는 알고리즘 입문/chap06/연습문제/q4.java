import java.util.Scanner;

public class q4 {
    static int compare_cnt = 0; // 비교 횟수
    static int change_cnt = 0;  // 교환 횟수

    static void swap(int[] a, int idx1, int idx2) {
        change_cnt++;
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬
    static void bubbleSort(int[] a, int n) {
        int k = 0; // a[k]보다 앞쪽은 정렬을 마친 상태
        int pass_cnt = 0; // 패스 수 세는 변수
        while (k < n - 1) {
            System.out.printf("패스%d:\n", ++pass_cnt);
            int last = n - 1; // 마지막으로 요소를 교환한 위치
            for (int j = n - 1; j > k; j--) {
                compare_cnt++;
                if (a[j-1] > a[j]) {
                    for (int e : a) {
                        System.out.printf("%d", e);
                        if (e == a[j-1]) {
                            System.out.print(" + ");
                        }
                        else System.out.print("   ");
                    }
                    System.out.println();
                    swap(a, j-1, j);
                    last = j;
                }
                else {
                    for (int e : a) {
                        System.out.printf("%d", e);
                        if (e == a[j-1]) {
                            System.out.print(" - ");
                        }
                        else System.out.print("   ");
                    }
                    System.out.println();
                }
            }
            for (int e : a) {
                System.out.printf("%d   ", e);
            }
            System.out.println();
            k = last;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전3)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx); // 버블 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
        System.out.println("비교를 " + compare_cnt + "회 했습니다.");
        System.out.println("교환을 " + change_cnt + "회 했습니다.");
    }
}
