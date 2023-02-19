/*
 * @author Minyeong Park
 * @date 2023.02.19.
 * 차량 번호판 1
 * 문제 링크 : https://www.acmicpc.net/problem/16968
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count;
        if (input.charAt(0) == 'd') {
            count = 10;
        } else {
            count = 26;
        }
        for (int i = 1; i < input.length(); i++) {
            int pre = input.charAt(i-1);
            int ch = input.charAt(i);
            if (ch == 'd' && pre == 'd') {
                count = count * 9;
            } else if (ch == 'd' && pre == 'c') {
                count *= 10;
            } else if (ch == 'c' && pre == 'd') {
                count *= 26;
            } else {
                count = count * 25;
            }
        }
        System.out.println(count);
    }
}