/*
 * @author Minyeong Park
 * @date 2022.07.16.
 * 부녀회장이 될테야
 * 문제 링크 : https://www.acmicpc.net/problem/2775
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = j+1;
            }
            for (int j = 0; j < k; j++) {
                for (int q = 1; q < n; q++) {
                    arr[q] = arr[q-1] + arr[q];
                }
            }

            System.out.println(arr[n-1]);
        }
    }
}