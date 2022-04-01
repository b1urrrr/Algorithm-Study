/*
 * @author Minyeong Park
 * @date 2022.04.01.
 * 분해합
 * 문제 링크 : https://www.acmicpc.net/problem/2231
 * 문제점 : 배열을 이용하고 문자열로 각 자리수를 잘라서인지 메모리와 시간을 너무 많이 낭비하는 매우 비효율적인 코드다!
 */

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N_str = br.readLine();        // N 문자열형
        int N_int = Integer.parseInt(N_str); // N 정수형

        int ctor = 0;          // 생성자
        int[] arr = new int[7];     // 각 자리 수를 담을 배열 (최대 7자리 수)
        for (int i = N_int; i > 0; i--) {
            Arrays.fill(arr,0);
            int arr_sum = 0;   // 각 자리수 합
            for (int j = 0; j < (i+"").length(); j++) {
                arr[j] = Character.getNumericValue((i+"").charAt(j));
                arr_sum += arr[j];
            }

            if (i + arr_sum == N_int) {
                ctor = i;
                break;
            }

        }

        bw.write(ctor + "");
        bw.flush();
    }
}