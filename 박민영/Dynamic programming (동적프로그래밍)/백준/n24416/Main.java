/*
 * @author Minyeong Park
 * @date 2022.06.02.
 * 알고리즘 수업 - 피보나치 수 1
 * 문제 링크 : https://www.acmicpc.net/problem/24416
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] f;
    static int count_recur = 0;
    static int count_dp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        count_recur++;
        fib(num);

        f = new int[num+1];
        fibonacci(num);

        System.out.println(count_recur + " " + count_dp);
    }

    static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        else {
            count_recur++;
            return fib(n-1) + fib(n-2);
        }
    }

    static int fibonacci(int n) {
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            count_dp++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}