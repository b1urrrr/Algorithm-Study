package 연습문제;

import java.util.Scanner;

public class q5 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬 (내가 푼 코드)
    static void bubbleSort(int[] a, int n) {
        int k = 0; // a[k]보다 앞쪽은 정렬을 마친 상태
        int shake_flag = 1;   // 홀 or 짝 번째 패스를 구별하는 변수

        while (k < n - 1) {
            int last = n - 1; // 마지막으로 요소를 교환한 위치
            if (shake_flag % 2 == 0) { // 짝수 번째 패스 : 가장 큰 요소를 맨 뒤로 옮기기
                for (int j = k + 1; j < n - 1; j++)
                    if (a[j-1] > a[j]) {
                        swap(a, j-1, j);
                        last = j;
                    }
                k = last;
                shake_flag++;
            } else {                   // 홀수 번째 패스 : 가장 작은 요소를 맨 앞으로 옮기기
                for (int j = n - 1; j > k; j--)
                    if (a[j-1] > a[j]) {
                        swap(a, j-1, j);
                        last = j;
                    }
                k = last;
                shake_flag++;
            }
        }
    }


    // 교재 풀이 코드
//    static void bubbleSort(int[] a, int n) {
//        int left = 0;
//        int right = n - 1;
//        int last = right;         // 마지막으로 요소를 교환한 위치
//
//        while (left < right) {
//            for (int j = right; j > left; j--) { // 홀수 번째 패스 : 가장 작은 요소를 정렬되지 않은 곳의 맨 앞으로 옮기기
//                if (a[j - 1] > a[j]) {           // 버블 정렬
//                    swap(a, j - 1, j);
//                    last = j;
//                }
//            }
//            left = last;         // left 이전은 이제 정렬된 것임
//
//            for (int j = left; j < right; j++) { // 짝수 번째 패스 : 가장 큰 요소를 정렬되지 않은 곳의 맨 뒤로 옮기기
//                if (a[j] > a[j + 1]) {           // 버블 정렬
//                    swap(a, j, j + 1);
//                    last = j;
//                }
//            }
//            right = last;         // right 이후는 이제 정렬된 것임
//        }
//    }

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
    }
}
