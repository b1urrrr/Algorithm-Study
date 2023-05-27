/*
 * @author Minyeong Park
 * @date 2023.05.21.
 * 진법 변환
 * 문제 링크 : https://www.acmicpc.net/problem/2745
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int dec_sum = 0;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (Character.isDigit(c)) {
                dec_sum += Character.digit(c, 10) * Math.pow(b, n.length() - i - 1);
            } else {
                dec_sum += ((c - 'A') + 10) * Math.pow(b, n.length() - i - 1);
            }
        }

        System.out.println(dec_sum);
    }
}