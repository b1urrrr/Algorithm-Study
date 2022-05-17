/*
 * @author Minyeong Park
 * @date 2022.04.08.
 * 평균은 넘겠지
 * 문제 링크 : https://www.acmicpc.net/problem/4344
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] score = new int[N];
            int sum = 0;
            for (int j = 0; j < N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }
            float average = sum / (float) N;  // 평균
            int count = 0;                    // 평균보다 높은 학생의 수
            for (int j = 0; j < N; j++) {
                if (score[j] > average)
                    count++;
            }
            float result = count / (float) N * 100;
            System.out.println(String.format("%.3f", result) + "%");
        }
    }
}
