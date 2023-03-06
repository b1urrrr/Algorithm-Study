/*
 * @author Minyeong Park
 * @date 2023.03.05.
 * 수들의 합 5
 * 원리 참고 : https://www.inflearn.com/course/lecture?courseSlug=%EB%91%90%EC%9E%87-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94&unitId=148341
 * 문제 링크 : https://www.acmicpc.net/problem/2018
 */



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) { // 아예 배열도 안 만들어도 됨!
            arr[i] = arr[i-1] + i;
        }

        int start_idx = 1;
        int end_idx = 1;
        int count = 0;

        while (start_idx <= n && end_idx <= n) {
            int sum = arr[end_idx] - arr[start_idx-1];
            if (sum < n) {
                end_idx++;
            } else if (sum > n) {
                start_idx++;
            } else {
                count++;
                end_idx++;
            }
        }

        System.out.println(count);
    }
}