/*
 * @author Minyeong Park
 * @date 2023.03.07.
 * 블로그
 * 문제 링크 : https://www.acmicpc.net/problem/21921
 */


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] a = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = a[i-1] + Integer.parseInt(st.nextToken());
        }

        int end_idx = n;
        int max = Integer.MIN_VALUE;
        while (end_idx >= x) {
            int temp_sum = a[end_idx] - a[end_idx - x];
            max = Math.max(temp_sum, max);
            end_idx--;
        }


        int count = 0;
        end_idx = n;
        while (end_idx >= x) {
            int temp_sum = a[end_idx] - a[end_idx - x];
            if (temp_sum == max) {
                count++;
            }
            end_idx--;
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}