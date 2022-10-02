/*
 * @author Minyeong Park
 * @date 2022.09.25.
 * 배열 합치기
 * 문제 링크 : https://www.acmicpc.net/problem/11728
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[n+m];
        int index = 0;
        int a_idx = 0;
        int b_idx = 0;

        while (a_idx < n && b_idx < m) {
            if (a[a_idx] < b[b_idx]) {
                arr[index] = a[a_idx];
                a_idx++;
                index++;
            } else {
                arr[index] = b[b_idx];
                b_idx++;
                index++;
            }
        }

        if (a_idx == n) {
            while (index < n+m) {
                arr[index] = b[b_idx];

                b_idx++;
                index++;
            }
        } else {
            while (index < n+m) {
                arr[index] = a[a_idx];

                a_idx++;
                index++;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}