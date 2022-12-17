/*
 * @author Minyeong Park
 * @date 2022.12.17.
 * 폴리오미노
 * 문제 링크 : https://www.acmicpc.net/problem/1343
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int index = 0;
        int continue_count = 0;
        StringBuilder sb = new StringBuilder();
        while (index < str.length()) {
            if (continue_count == 4) {
                sb.append("AAAA");
                continue_count = 0;
            }

            if (str.charAt(index) == 'X') {
                continue_count++;
                if (index + 1 >= str.length() || str.charAt(index + 1) == '.') {
                    if (continue_count == 4) {
                        sb.append("AAAA");
                    } else if (continue_count == 2) {
                        sb.append("BB");
                    } else {
                        System.out.println(-1);
                        return;
                    }
                    continue_count = 0;
                }
                index++;
            } else { // 현재가 . 인 경우
                sb.append(".");
                index++;
                continue_count = 0;
            }
        }

        System.out.println(sb);
    }
}