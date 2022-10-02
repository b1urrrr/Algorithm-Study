/*
 * @author Minyeong Park
 * @date 2022.06.24.
 * ATM
 * 문제 링크 : https://www.acmicpc.net/problem/11399
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = arr[i] + sum[i-1];
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += sum[i];
        }
        System.out.println(result);
    }
}