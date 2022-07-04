/*
 * @author Minyeong Park
 * @date 2022.07.04.
 * 최소공배수 (다른 코드 공부 - 유클리드 알고리즘)
 * 참고 : https://velog.io/@soyeon207/%EC%B5%9C%EB%8C%80%EA%B3%B5%EC%95%BD%EC%88%98GCD-%EC%B5%9C%EC%86%8C%EA%B3%B5%EB%B0%B0%EC%88%98LCM-%EA%B3%BC-%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Euclidean-algorithm
 * 문제 링크 : https://www.acmicpc.net/problem/1934
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            int temp_a = a;
            int temp_b = b;
            int r = 1;

            while (temp_a % temp_b != 0) {
                r = temp_a % temp_b;
                temp_a = temp_b;
                temp_b = r;
            }

            System.out.println(a * b / temp_b);
        }
    }
}