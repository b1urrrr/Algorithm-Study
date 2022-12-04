/*
 * @author Minyeong Park
 * @date 2022.12.04.
 * 뒤집힌 덧셈
 * 문제 링크 : https://www.acmicpc.net/problem/1357
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        String a_n = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            a_n = a_n + a.charAt(i);
        }
        String b_n = "";
        for (int i = b.length() - 1; i >= 0; i--) {
            b_n = b_n + b.charAt(i);
        }
        String sum = String.valueOf(Integer.parseInt(a_n) + Integer.parseInt(b_n));
        String sum_n = "";
        for (int i = sum.length() - 1; i >= 0; i--) {
            if (sum.charAt(i) == '0' && sum_n.equals("")) continue;
            sum_n = sum_n + sum.charAt(i);
        }
        System.out.println(sum_n);
    }
}