/*
 * @author Minyeong Park
 * @date 2023.04.09.
 * 성적 통계
 * 문제 링크 : https://www.acmicpc.net/problem/5800
 */


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] grade = new int[n];
            for (int j = 0; j < n; j++) {
                grade[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(grade);
            int largest_gap = 0;
            for (int j = 1; j < n; j++) {
                largest_gap = Math.max(largest_gap, grade[j] - grade[j-1]);
            }

            sb.append("Class " + (i + 1) + "\n");
            sb.append("Max " + grade[n - 1] + ", Min " + grade[0] + ", Largest gap " + largest_gap + "\n");
        }
        System.out.println(sb);
    }
}