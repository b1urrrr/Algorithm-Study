/*
 * @author Minyeong Park
 * @date 2022.09.04.
 * 날짜 계산
 * 문제 링크 : https://www.acmicpc.net/problem/1476
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int year = 1;
        int temp_e = 1, temp_s = 1, temp_m = 1;
        while (temp_e != e || temp_s != s || temp_m != m) {
            temp_e += 1;
            temp_s += 1;
            temp_m += 1;

            if (temp_e > 15) {
                temp_e -= 15;
            }
            if (temp_s > 28) {
                temp_s -= 28;
            }
            if (temp_m > 19) {
                temp_m -= 19;
            }
            year++;
        }
        System.out.println(year);
    }
}