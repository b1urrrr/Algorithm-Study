package chap11;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Question11_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] travelers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            travelers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(travelers);
        int result = 0;
        int count = 0;
        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(travelers[i], max);
            count++;

            if (max == count) {
                result++;
                count = 0;
            }
        }

        System.out.println(result);
    }
}