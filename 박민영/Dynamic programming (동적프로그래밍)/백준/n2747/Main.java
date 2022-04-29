/*
 * @author Minyeong Park
 * @date 2022.04.29.
 * 피보나치 수
 * 문제 링크 : https://www.acmicpc.net/problem/2747
 */

import java.io.*;

public class Main {
    static int[] fibo_arr;
    static void fibo(int num) {
        for (int i = 2; i < num; i++) {
            fibo_arr[i] = fibo_arr[i - 1] + fibo_arr[i - 2];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo_arr = new int[n+1];

        fibo_arr[0] = 0;
        fibo_arr[1] = 1;
        fibo(n+1);
        System.out.println(fibo_arr[n]);
    }
}