/*
 * @author Minyeong Park
 * @date 2022.07.16.
 * 단어 공부(다른 코드 공부)
 * 출처 : https://st-lab.tistory.com/64
 * 문제 링크 : https://www.acmicpc.net/problem/1157
 */

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase(Locale.ROOT);

        int[] arr = new int[26]; // 영문자의 개수는 26개

        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                arr[str.charAt(i) - 'A']++; // 해당 인덱스의 값 1 증가
        }

        int max = -1;
        char ch = '?';

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char) (i + 65); // 대문자로 출력해야 하므로 65를 더함
            } else if (arr[i] == max) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}