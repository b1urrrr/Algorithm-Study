/*
 * @author Minyeong Park
 * @date 2023.02.19.
 * solved.ac
 * 문제 링크 : https://www.acmicpc.net/problem/18110
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int del_cnt = (int) Math.round(n * 0.15);
        int sum = 0;
        Arrays.sort(arr);
        for (int i = del_cnt; i < n - del_cnt; i++) {
            sum += arr[i];
        }
        System.out.println(Math.round((double) sum / (n - del_cnt * 2)));
    }
}