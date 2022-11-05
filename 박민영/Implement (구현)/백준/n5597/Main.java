/*
 * @author Minyeong Park
 * @date 2022.11.05.
 * 과제 안 내신 분..?
 * 문제 링크 : https://www.acmicpc.net/problem/5597
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] students = new boolean[31];
        for (int i = 0; i < 28; i++) {
            int submit_student = Integer.parseInt(br.readLine());
            students[submit_student] = true;
        }

        for (int i = 1; i < students.length; i++) {
            if (!students[i]) {
                System.out.println(i);
            }
        }
    }
}