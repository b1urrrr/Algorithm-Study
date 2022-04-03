/*
 * @author Minyeong Park
 * @date 2022.04.03.
 * 소수 찾기
 * 문제 링크 : https://www.acmicpc.net/problem/1978
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num_arr = new int[N]; // N개의 수를 담는 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num_arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0; // 소수의 개수

        for (int i : num_arr) {
            if (i == 1) {
                continue;
            }
            if (i == 2) {
                count++;
                continue;
            }
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    break;
                if (j == i - 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}