/*
 * @author Minyeong Park
 * @date 2022.10.01.
 * 예산 (다른 풀이 공부)
 * 출처 : https://loosie.tistory.com/552
 * 문제 링크 : https://www.acmicpc.net/problem/2512
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int min = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        m = Integer.parseInt(br.readLine());

        while (min <= max) {
            int mid = (min + max) / 2;
            long budget = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    budget += mid;
                } else {
                    budget += arr[i];
                }
            }

            if (budget <= m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);

    }
}