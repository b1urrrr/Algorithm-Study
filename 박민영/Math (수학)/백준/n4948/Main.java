/*
 * @author Minyeong Park
 * @date 2022.05.15.
 * 베르트랑 공준
 * 참고 : https://st-lab.tistory.com/85
 * 문제 링크 : https://www.acmicpc.net/problem/4948
 */

import java.io.*;

public class Main {
    static boolean[] prime = new boolean[246913]; // 123456 * 2 + 1개 // true : 소수 X, false : 소수 O
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        get_prime();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            int count = 0;
            for (int i = n+1; i <= 2*n; i++) {
                if (!prime[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static void get_prime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            // i가 소수가 아닌 경우, i의 배수들을 걸러주기 위한 반복문
            // i * i 부터 시작하는 이유 : i * (i보다 작은 수)는 이미 앞의 반복문에서 걸러주었기 때문
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}