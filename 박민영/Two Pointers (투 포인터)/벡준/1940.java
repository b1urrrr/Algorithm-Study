/*
 * @author Minyeong Park
 * @date 2023.03.07.
 * 주몽
 * 접근 참고 : https://www.inflearn.com/course/lecture?courseSlug=%EB%91%90%EC%9E%87-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94&unitId=148342&tab=curriculum
 * 문제 링크 : https://www.acmicpc.net/problem/1940
 */



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start_idx = 0;
        int end_idx = arr.length - 1;
        int count = 0;
        while (start_idx < end_idx) {
            int sum = arr[start_idx] + arr[end_idx];
            if (sum < m) {
                start_idx++;
            } else if (sum > m) {
                end_idx--;
            } else if (sum == m) {
                start_idx++;
                count++;
            }
        }
        System.out.println(count);
    }
}