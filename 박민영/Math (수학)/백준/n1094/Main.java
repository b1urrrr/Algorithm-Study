/*
 * @author Minyeong Park
 * @date 2022.08.28.
 * 막대기
 * 문제 링크 : https://www.acmicpc.net/problem/1094
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int mark = 64;
        int count = 0;
        while (x != 0) {
            if (x - mark >= 0) {
                x = x - mark;
                count++;
            }
            mark /= 2;
        }

        System.out.println(count);
    }
}