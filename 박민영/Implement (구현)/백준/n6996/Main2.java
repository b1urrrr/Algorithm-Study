/*
 * @author Minyeong Park
 * @date 2022.12.11.
 * 애너그램 (다른 풀이 공부)
 * 출처 : https://velog.io/@cjhlsb/Algorithm-%EB%B0%B1%EC%A4%80-6996%EB%B2%88-%EC%95%A0%EB%84%88%EA%B7%B8%EB%9F%BC
 * 문제 링크 : https://www.acmicpc.net/problem/6996
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken().toLowerCase();
            String b = st.nextToken().toLowerCase();

            System.out.println(a + " & " + b + " are " + (solveAnagrams(a, b) ? "anagrams." : "NOT anagrams."));
        }
    }

    private static boolean solveAnagrams(String first, String second ) {
        if (first.length() != second.length()) {
            return false;
        }

        char[] a_arr = first.toCharArray();
        char[] b_arr = second.toCharArray();
        Arrays.sort(a_arr);
        Arrays.sort(b_arr);

        if (Arrays.equals(a_arr, b_arr)) {
            return true;
        } else {
            return false;
        }
    }
}