/*
 * @author Minyeong Park
 * @date 2022.08.27.
 * 캠핑
 * 원리 참고 : https://propercoding.tistory.com/240
 * 문제 링크 : https://www.acmicpc.net/problem/4796
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input_str;
        int l, p, v, result;
        int case_count = 0;
        while (!(input_str = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(input_str);
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            result = v / p * l + Math.min(v % p, l);
            System.out.println("Case " + ++case_count + ": " + result);
        }
    }
}