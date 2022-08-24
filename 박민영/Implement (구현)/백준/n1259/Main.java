/*
 * @author Minyeong Park
 * @date 2022.07.26.
 * 팰린드롬수
 * 문제 링크 : https://www.acmicpc.net/problem/1259
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (!(input = br.readLine()).equals("0")) {
            boolean is_pal = true;
            for (int i = 0; i < input.length() / 2; i++) {
                char a = input.charAt(i);
                char b = input.charAt(input.length() - i - 1);
                if (a == b) {
                    continue;
                } else {
                    is_pal = false;
                    break;
                }
            }
            if (is_pal)
                System.out.println("yes");
            else {
                System.out.println("no");
            }
        }
    }
}