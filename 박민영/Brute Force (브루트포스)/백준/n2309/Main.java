/*
 * @author Minyeong Park
 * @date 2022.08.20.
 * 일곱 난쟁이
 * 문제 링크 : https://www.acmicpc.net/problem/2309
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int nine_sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            nine_sum += arr[i];
        }

        Arrays.sort(arr);

        int remove_idx1 = 0;
        int remove_idx2 = 0;
        Loop1:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (nine_sum - arr[i] - arr[j] == 100) {
                    remove_idx1 = i;
                    remove_idx2 = j;
                    break Loop1;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == remove_idx1 || i == remove_idx2)
                continue;
            else
                System.out.println(arr[i]);
        }

    }
}