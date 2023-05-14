/*
 * @author Minyeong Park
 * @date 2023.05.14.
 * 암기왕
 * 문제 링크 : https://www.acmicpc.net/problem/2776
 */


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] note1 = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note1);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int find = Integer.parseInt(st.nextToken());
                int left_index = 0;
                int right_index = n-1;
                sb.append(binarySearch(note1, left_index, right_index, find) + "\n");
            }

            t--;
        }

        System.out.println(sb);
    }

    static int binarySearch(int[] list, int left_index, int right_index, int target) {
        while (left_index <= right_index) {
            int mid = (left_index + right_index) / 2;
            if (list[mid] == target) {
                return 1;
            } else if (list[mid] < target) {
                left_index = mid + 1;
            } else {
                right_index = mid - 1;
            }
        }
        return 0;
    }
}