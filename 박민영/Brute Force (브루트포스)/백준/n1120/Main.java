/*
 * @author Minyeong Park
 * @date 2022.10.16.
 * 문자열
 * 원리 참고 : https://velog.io/@think2wice/%EB%B0%B1%EC%A4%80-%EB%AC%B8%EC%A0%9C-1120%EB%B2%88-%EB%AC%B8%EC%9E%90%EC%97%B4-Java
 * 문제 링크 : https://www.acmicpc.net/problem/1120
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int min_count = 50;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            int temp_count = 0;
            for (int a_idx = 0; a_idx < a.length(); a_idx++) {
                if (a.charAt(a_idx) != b.charAt(a_idx + i)) {
                    temp_count++;
                }
            }
            if (temp_count < min_count) {
                min_count = temp_count;
            }
        }
        System.out.println(min_count);
    }
}