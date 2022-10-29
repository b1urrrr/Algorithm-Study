/*
 * @author Minyeong Park
 * @date 2022.10.28.
 * Base Conversion
 * 반례 참고 : https://www.acmicpc.net/board/view/91446
 * 문제 링크 : https://www.acmicpc.net/problem/11576
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int num_dec = 0;
        for (int i = m; i > 0; i--) {
            num_dec += (int) (Math.pow(a, i-1) * Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        while (num_dec >= Math.pow(b, count)) {
            count++;
        }

        for (int i = count; i > 0; i--) {
            System.out.print((int) (num_dec / Math.pow(b, i-1)) + " ");
            num_dec %= (int) Math.pow(b, i-1);
        }
    }
}