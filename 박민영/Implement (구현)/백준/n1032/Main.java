/*
 * @author Minyeong Park
 * @date 2022.08.09.
 * 명령 프롬프트
 * 문제 링크 : https://www.acmicpc.net/problem/1032
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int length = arr[0].length();
        char[] answer_ch = new char[length];
        for (int i = 0; i < length; i++) {
            answer_ch[i] = arr[0].charAt(i);
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < n; j++) {
                if (answer_ch[i] != arr[j].charAt(i)) {
                    answer_ch[i] = '?';
                    break;
                }
            }
        }

        for (char c : answer_ch) {
            System.out.print(c);
        }
    }
}