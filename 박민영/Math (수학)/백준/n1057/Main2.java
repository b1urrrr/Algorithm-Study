/*
 * @author Minyeong Park
 * @date 2023.01.18.
 * 토너먼트 (다른 사람 풀이)
 * 출처 : https://1-7171771.tistory.com/21
 * 문제 링크 : https://www.acmicpc.net/problem/1057
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int round_cnt = 0;

        while (j != h) {
            j = j / 2 + j % 2;
            h = h / 2 + h % 2;
            round_cnt++;
        }

        System.out.println(round_cnt);
    }
}