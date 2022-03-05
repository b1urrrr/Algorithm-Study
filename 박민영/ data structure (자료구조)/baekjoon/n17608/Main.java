/*
 * @author Minyeong Park
 * @date 2022.03.06.
 * 막대기
 * https://www.acmicpc.net/problem/17608
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int p = arr[n - 1]; // 맨 오른쪽 막대기 높이
        int temp_min = arr[n - 1];
        int count = 1;      // 보이는 막대기의 개수 (맨 오른쪽 것은 무조건 보이니까 디폴트는 1)
        for (int i = n - 1; i >= 0; i--) {
            if (p < arr[i] && temp_min < arr[i]) {
                temp_min = arr[i];
                count++;
            }
        }
        bw.write(count + "");
        bw.flush();
    }
}