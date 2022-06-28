package chap08;

import java.io.*;
import java.util.StringTokenizer;

public class Practice8_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] foods = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            foods[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i < N; i++) {
            // i - 1번 식량창고를 터는 경우와 i - 2번과 i번 식량창고를 터는 경우 중 최대값 저장
            foods[i] = Math.max(foods[i - 1], foods[i - 2] + foods[i]);
        }

        System.out.println(foods[N - 1]);
    }    
}
