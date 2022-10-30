/*
 * @author Minyeong Park
 * @date 2022.10.30.
 * 학생 번호
 * 문제 링크 : https://www.acmicpc.net/problem/1235
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] students = new String[n];
        for (int i = 0; i < n; i++) {
            students[i] = br.readLine();
        }

        int k = 1;
        int total_length = students[0].length();
        while (k < total_length) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String slice_str = students[i].substring(total_length - k, total_length);
                set.add(slice_str);
            }

            if (set.size() == n) {
                break;
            } else {
                k++;
            }
        }

        System.out.println(k);
    }
}