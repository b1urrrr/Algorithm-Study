/*
 * @author Minyeong Park
 * @date 2023.02.19.
 * 오르막길
 * 문제 링크 : https://www.acmicpc.net/problem/2846
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int rst_height = 0;

        int temp_start_idx = 0;
        int temp_height = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]) {
                temp_height = arr[i] - arr[temp_start_idx];
                rst_height = Math.max(temp_height, rst_height);
            } else {
                temp_start_idx = i;
                temp_height = 0;
            }
        }
        System.out.println(rst_height);
    }
}