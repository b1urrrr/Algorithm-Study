/*
 * @author Minyeong Park
 * @date 2022.08.06.
 * 방 번호
 * 문제 링크 : https://www.acmicpc.net/problem/1475
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String room = br.readLine();
        int[] arr = new int[9]; // 0 ~ 8까지 이용 예정
        for (int i = 0; i < room.length(); i++) {
            int num = room.charAt(i) - '0';
            if (num == 9) {
                arr[6]++;
                continue;
            }
            arr[num]++;
        }

        if (arr[6] % 2 == 0) {
            arr[6] = arr[6] / 2;
        } else {
            arr[6] = arr[6] / 2 + 1;
        }

        int max_count = 0;
        for (int i = 0; i < arr.length; i++) {
            max_count = Math.max(arr[i], max_count);
        }
        System.out.println(max_count);
    }
}