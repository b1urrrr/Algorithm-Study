/*
 * @author Minyeong Park
 * @date 2022.07.12.
 * ACM호텔
 * 문제 링크 : https://www.acmicpc.net/problem/10250
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int x = (n % h == 0) ? n / h : n / h + 1;
            int y = (n % h == 0) ? h : n % h;

            if (x < 10) {
                System.out.println(y + "0" + x);
            } else {
                System.out.println(y + "" + x);
            }
        }
    }
}