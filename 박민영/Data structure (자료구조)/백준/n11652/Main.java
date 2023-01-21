/*
 * @author Minyeong Park
 * @date 2023.01.21.
 * 카드 (오류 고치는 중)
 * 문제 링크 : https://www.acmicpc.net/problem/17218
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 1));
        }

        int max_cnt = 0;
        for (int count : map.values()) {
            max_cnt = Math.max(max_cnt, count);
        }

        long answer = (long) Math.pow(2, 62) + 1;
        for (long key : map.keySet()) {
            if (max_cnt == map.get(key) && key < answer) {
                answer = key;
            }
        }
        System.out.println(answer);
    }
}