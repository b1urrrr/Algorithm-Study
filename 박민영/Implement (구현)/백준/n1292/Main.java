/*
 * @author Minyeong Park
 * @date 2022.08.10.
 * 쉽게 푸는 문제
 * 문제 링크 : https://www.acmicpc.net/problem/1292
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[b];
        int index = 0;
        for (int i = 1; index < b; i++) {
            for (int j = 1; j <= i; j++) {
                arr[index] = i;
                index++;
                if (index >= b) {
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = a-1; i < b; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}