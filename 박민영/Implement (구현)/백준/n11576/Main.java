/*
 * @author Minyeong Park
 * @date 2022.10.28.
 * Base Conversion
 * 문제 링크 : https://www.acmicpc.net/problem/11576
 */

// 현재 진행 중이라서 완료된 코드는 아님...

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
        int num = 0;
        for (int i = m; i > 0; i--) {
            num += (int) (Math.pow(a, i-1) * Integer.parseInt(st.nextToken()));
        }

        for (int i = m; i > 0; i--) {
            System.out.print((int) (num / Math.pow(b, i-1)) + " ");
            num %= (int) Math.pow(b, i-1);
        }
    }
}