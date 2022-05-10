/*
 * @author Minyeong Park
 * @date 2022.05.08.
 * 직각삼각형
 * 문제 링크 : https://www.acmicpc.net/problem/4153
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str;
        while (!(str = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(str);
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long max = Math.max(Math.max(a, b), c);
            long left1;
            long left2;
            if (a == max) {
                left1 = b;
                left2 = c;
            } else if (b == max) {
                left1 = a;
                left2 = c;
            } else {
                left1 = a;
                left2 = b;
            }
            if (Math.pow(left1,2) + Math.pow(left2,2) == Math.pow(max,2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}