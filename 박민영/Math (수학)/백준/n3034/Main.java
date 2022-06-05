/*
 * @author Minyeong Park
 * @date 2022.05.27.
 * 앵그리 창영
 * 문제 링크 : https://www.acmicpc.net/problem/3034
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int diagonal = (int) Math.sqrt(Math.pow(w,2) + Math.pow(h,2));

        for (int i = 0; i < n; i++) {
            int matches = Integer.parseInt(br.readLine());
            if (matches <= diagonal) {
                System.out.println("DA");
                continue;
            }
            System.out.println("NE");
        }
    }
}