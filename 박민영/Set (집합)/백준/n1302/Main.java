/*
 * @author Minyeong Park
 * @date 2022.12.11.
 * 베스트셀러
 * 메서드 참고 : https://developer-talk.tistory.com/402
 * 문제 링크 : https://www.acmicpc.net/problem/1302
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        int max_count = 0;
        String max_book = "";

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            max_book = book;
            if (map.containsKey(book)) {
                map.put(book, map.get(book) + 1);
            } else {
                map.put(book, 1);
            }
        }


        for (String key : map.keySet()) {
            if (map.get(key) > max_count) {
                max_book = key;
                max_count = map.get(key);
            }
            if (map.get(key) == max_count) {
                if (key.compareTo(max_book) < 0) { // key가 더 사전 순으로 앞서 있으면
                    max_book = key;
                }
            }
        }

        System.out.println(max_book);
    }
}