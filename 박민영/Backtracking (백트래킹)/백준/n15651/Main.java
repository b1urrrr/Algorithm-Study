/*
 * @author Minyeong Park
 * @date 2022.04.24.
 * N과 M (3)
 * 문제 링크 : https://www.acmicpc.net/problem/15651
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, M;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void func(int depth) throws IOException {
        if (depth == M) {
            for (int num : arr) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            func(depth + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        func(0);
        bw.flush();
    }
}