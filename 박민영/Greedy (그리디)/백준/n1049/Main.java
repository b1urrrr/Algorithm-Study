/*
 * @author Minyeong Park
 * @date 2022.10.01.
 * 기타줄
 * 문제 링크 : https://www.acmicpc.net/problem/1049
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] package6 = new int[m];
        int[] single = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            package6[i] = Integer.parseInt(st.nextToken());
            single[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(package6);
        Arrays.sort(single);

        int a_sum = 0;
        int a_count = 0;
        while (a_count < n) {
            a_count += 6;
            a_sum += package6[0];
        }

        int b_sum = 0;
        int b_count = 0;
        while (b_count < n) {
            b_count += 1;
            b_sum += single[0];
        }

        int c_sum = 0;
        int c_count = 0;
        while (c_count+6 < n) {
            c_count += 6;
            c_sum += package6[0];
        }
        while (c_count < n) {
            c_count += 1;
            c_sum += single[0];
        }

        int result = Math.min(a_sum, Math.min(b_sum, c_sum));
        System.out.println(result);
    }
}