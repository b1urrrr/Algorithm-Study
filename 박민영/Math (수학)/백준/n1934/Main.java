/*
 * @author Minyeong Park
 * @date 2022.07.04.
 * 최소공배수 (그냥 브루트포스로 풀었음)
 * 문제 링크 : https://www.acmicpc.net/problem/1934
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = Math.min(a,b);
            int max_factor = 1;
            for (int temp_factor = 2; temp_factor <= min; temp_factor++) {
                if (a % temp_factor == 0 && b % temp_factor == 0) {
                    max_factor = temp_factor;
                }
            }

            System.out.println(a * b / max_factor);
        }
    }
}