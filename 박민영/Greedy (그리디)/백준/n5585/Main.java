/*
 * @author Minyeong Park
 * @date 2022.12.18.
 * 거스름돈
 * 문제 링크 : https://www.acmicpc.net/problem/5585
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int rest = 1000 - n;
        int count = 0;
        while (rest > 0) {
            if (rest >= 500) {
                count++;
                rest -= 500;
            } else if (rest >= 100) {
                count++;
                rest -= 100;
            } else if (rest >= 50) {
                count++;
                rest -= 50;
            } else if (rest >= 10) {
                count++;
                rest -= 10;
            } else if (rest >= 5) {
                count++;
                rest -= 5;
            } else if (rest >= 1) {
                count++;
                rest -= 1;
            }
        }

        System.out.println(count);
    }
}