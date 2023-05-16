/*
 * @author Minyeong Park
 * @date 2023.05.14.
 * CD
 * 문제 링크 : https://www.acmicpc.net/problem/4158
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = "";
        while (!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] sanggeun = new int[n];
            for (int i = 0; i < n; i++) {
                sanggeun[i] = Integer.parseInt(br.readLine());
            }

            int[] sunyeong = new int[m];
            for (int i = 0; i < m; i++) {
                sunyeong[i] = Integer.parseInt(br.readLine());
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (binarySearch(sunyeong, 0, m - 1, sanggeun[i])) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static boolean binarySearch(int[] list, int left_index, int right_index, int target) {
        while (left_index <= right_index) {
            int mid = (left_index + right_index) / 2;
            if (list[mid] == target) {
                return true;
            } else if (list[mid] < target) {
                left_index = mid + 1;
            } else {
                right_index = mid - 1;
            }
        }
        return false;
    }
}