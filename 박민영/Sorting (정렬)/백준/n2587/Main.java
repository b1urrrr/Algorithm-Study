/*
 * @author Minyeong Park
 * @date 2022.11.27.
 * 대표값2
 * 문제 링크 : https://www.acmicpc.net/problem/2587
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        System.out.println(sum / 5);
        Arrays.sort(arr);
        System.out.println(arr[2]);
    }
}