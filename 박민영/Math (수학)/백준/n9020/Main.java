/*
 * @author Minyeong Park
 * @date 2022.05.15.
 * 골드바흐의 추측
 * 참고 : 에라토스테네스의 체
 * 문제 링크 : https://www.acmicpc.net/problem/9020
 */

import java.io.*;

public class Main {
    static boolean[] flag = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        get_prime();
        for (int i = 0; i < T; i++) {
             int n = Integer.parseInt(br.readLine());
             int n1 = 0, n2 = 0;
             for (int j = 2; j <= n/2; j++) {
                 if (!flag[j] && !flag[n-j]) {
                     n1 = j;
                     n2 = n - j;
                 }
             }
             System.out.println(n1 + " " + n2);
        }
    }

    static void get_prime() {
        flag[0] = flag[1] = true;
        for (int i = 2; i <= Math.sqrt(flag.length); i++) {
            if (flag[i])
                continue;
            for (int j = i * i; j < flag.length; j += i)
                flag[j] = true;
        }
    }
}