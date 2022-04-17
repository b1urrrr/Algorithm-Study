/*
 * @author Minyeong Park
 * @date 2022.04.17.
 * 벌집
 * 문제 링크 : https://www.acmicpc.net/problem/2292
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        // 2개 이상의 방
        int count = 1;     // 몇 번째 단계인지 (2~7번 : 1단계, 8~19번 : 2단계, 20~37번 : 3단계...)
        int last_room = 1; // 해당 단계에서의 마지막 방 번호

        while (N > last_room + count * 6) {
            last_room += count * 6;
            count++;
        }
        System.out.println(count + 1);
    }
}