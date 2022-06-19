/*
 * @author Minyeong Park
 * @date 2022.06.19.
 * 하키
 * 문제 링크 : https://www.acmicpc.net/problem/1358
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()); // 선수의 수

        int count = 0;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());

            if (Math.pow(px - x, 2) + Math.pow(py - (y + h/2),2) <= Math.pow(h/2,2)) {
                count++;
                continue;
            }
            if (Math.pow(px - (x+w), 2) + Math.pow(py - (y + h/2),2) <= Math.pow(h/2,2)) {
                count++;
                continue;
            }
            if (px >= x && px <= x+w && py >= y && py <= y+h) {
                count++;
                continue;
            }
        }

        System.out.println(count);
    }
}