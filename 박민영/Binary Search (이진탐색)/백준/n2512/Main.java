/*
 * @author Minyeong Park
 * @date 2022.10.01.
 * 예산
 * 반례 참고 : https://www.acmicpc.net/board/view/71578
 * 문제 링크 : https://www.acmicpc.net/problem/2512
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int result;
    static boolean[] flag = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int min = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        m = Integer.parseInt(br.readLine());

        System.out.println(Search(min, max));

    }

    static int Search(int start, int end) {
        int mid = (start + end) / 2;
        if (flag[mid]) {
            return result;
        }

        flag[mid] = true;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= mid) {
                sum += arr[i];
            } else {
                sum += mid;
            }
        }

        if (sum == m) {
            return result = mid;
        } else if (sum > m) {
            return Search(start, mid);
        } else {
            result = mid;
            return Search(mid + 1, end);
        }
    }
}