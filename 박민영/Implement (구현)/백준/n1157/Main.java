/*
 * @author Minyeong Park
 * @date 2022.07.16.
 * 단어 공부
 * 문제 링크 : https://www.acmicpc.net/problem/1157
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase(Locale.ROOT);

        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        char max_ch = '`';
        int max_count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if (count > max_count) {
                max_count = count;
                max_ch = ch;
            }
        }

        int dupicate = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count == max_count) {
                dupicate++;
            }
        }

        if (dupicate >= 2) {
            System.out.println("?");
        } else {
            System.out.println(max_ch);
        }
    }
}