/*
 * @author Minyeong Park
 * @date 2023.05.21.
 * 세탁소 사장 동혁
 * 문제 링크 : https://www.acmicpc.net/problem/2720
 */


import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());

            sb.append(c / 25 + " ");
            c = c % 25;

            sb.append(c / 10 + " ");
            c = c % 10;

            sb.append(c / 5 + " ");
            c = c % 5;

            sb.append(c + "\n");
        }
        System.out.println(sb);
    }
}