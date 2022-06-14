package chap06;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

// 위에서 아래로
public class Practice6_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열에 속해 있는 수의 개수 N 입력
        Integer[] array = new Integer[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine()); // 수 입력
        }

        // 역순으로 정렬
        Arrays.sort(array, Collections.reverseOrder());

        // 수열이 내림차순으로 정렬된 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
