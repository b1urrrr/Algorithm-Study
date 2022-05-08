/*
 * @author Minyeong Park
 * @date 2022.05.07.
 * 직사각형에서 탈출
 * 문제 링크 : https://www.acmicpc.net/problem/1085
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = Math.min(x, y);
        min = Math.min(min, w - x);
        min = Math.min(min, h - y);

        System.out.println(min);
    }
}