/*
 * @author Minyeong Park
 * @date 2022.04.24.
 * 소수 구하기
 * 문제 링크 : https://www.acmicpc.net/problem/1929
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1]; // true : 소수 X , false : 소수 O

        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i < N; i++) {
            for (int j = i + i; j <= N; j += i) {
                arr[j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i] == false) {
                System.out.println(i);
            }
        }
    }
}