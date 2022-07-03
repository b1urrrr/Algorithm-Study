/*
 * @author Minyeong Park
 * @date 2022.07.03.
 * 수열
 * 문제 링크 : https://www.acmicpc.net/problem/2559
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
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum_arr = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            sum_arr[0] += arr[i];
        }

        for (int i = 1; i < sum_arr.length; i++) {
            sum_arr[i] = sum_arr[i-1] - arr[i-1] + arr[i-1+k];
        }

        int max = -999999999; // 매우 작은 수로 초기화
        for (int i = 0; i < sum_arr.length; i++) {
            if (sum_arr[i] >= max)
                max = sum_arr[i];
        }

        System.out.println(max);
    }
}