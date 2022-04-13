/*
 * @author Minyeong Park
 * @date 2022.04.13.
 * 소인수분해
 * 문제 링크 : https://www.acmicpc.net/problem/11653
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int mod_num = 2; // 나누는 수
        int left = 0;    // 나누고 남은 수
        while (left != 1 && mod_num <= N) {
            while (N % mod_num == 0) {
                System.out.println(mod_num);
                N = N / mod_num;
            }
            mod_num++;
        }
    }
}