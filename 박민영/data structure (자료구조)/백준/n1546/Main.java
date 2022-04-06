/*
 * @author Minyeong Park
 * @date 2022.04.06.
 * 평균
 * 문제 링크 : https://www.acmicpc.net/problem/1546
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] score = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0;
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            if (score[i] > max)
                max = (double) score[i];
        }

        for (int i = 0; i < N; i++) {
            score[i] = score[i] / max * 100;
        }

        double result = 0;

        for (double i : score)
            result += i;
        result /= (double) N;

        System.out.println(result);

    }
}