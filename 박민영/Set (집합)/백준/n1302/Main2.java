/*
 * @author Minyeong Park
 * @date 2022.12.11.
 * 베스트셀러 (다른 풀이 참고)
 * 출처 : https://zoonvivor.tistory.com/138
 * 문제 링크 : https://www.acmicpc.net/problem/1302
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (map.containsKey(book)) {
                map.replace(book, map.get(book) + 1); // replace 쓰기
            } else {
                map.put(book, 1);
            }
        }

        int max_count = 0;

        for (String key : map.keySet()) {
            max_count = Math.max(max_count, map.get(key));
        }

        ArrayList<String> arrayList = new ArrayList<String>(map.keySet()); // map의 키들을 가지고 arraylist로 만듦
        Collections.sort(arrayList);
        for (String book : arrayList) {
            if (map.get(book) == max_count) {
                System.out.println(book);
                break;
            }
        }
    }
}