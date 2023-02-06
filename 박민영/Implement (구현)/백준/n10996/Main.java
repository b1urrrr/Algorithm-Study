/*
 * @author Minyeong Park
 * @date 2023.02.05.
 * 별 찍기 - 21
 * 문제 링크 : https://www.acmicpc.net/problem/10996
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println("*");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (k % 2 == 0) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }

            }
            sb.append("\n");
            for (int k = 0; k < n; k++) {
                if (k % 2 == 0) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}