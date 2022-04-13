/*
 * @author Minyeong Park
 * @date 2022.04.13.
 * 소인수분해 (다른 풀이)
 * 출처 : https://st-lab.tistory.com/152
 * 문제 링크 : https://www.acmicpc.net/problem/11653
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int mod_num = 2; // 나누는 수
        int left = 0;    // 나누고 남은 수
        while (left != 1 && mod_num <= Math.sqrt(N)) { // N의 제곱근 이하 수까지만 나누고
            while (N % mod_num == 0) {
                System.out.println(mod_num);
                N = N / mod_num;
            }
            mod_num++;
        }

        if (N != 1)      //  N이 1이 아니면 그 남은 수를 한번 더 출력 (그 수는 이미 나눠진 수와 대응되는 '나누는 수')
            System.out.println(N);
    }
}