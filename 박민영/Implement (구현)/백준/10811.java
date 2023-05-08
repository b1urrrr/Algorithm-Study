/*
 * @author Minyeong Park
 * @date 2023.05.07.
 * 바구니 뒤집기
 * 문제 링크 : https://www.acmicpc.net/problem/10811
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int cnt = 1; cnt <= n; cnt++) {
            arr[cnt] = cnt;
        }
        for (int cnt = 0; cnt < m; cnt++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            while (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        for (int cnt = 1; cnt <= n; cnt++) {
            System.out.print(arr[cnt] + " ");
        }
    }
}