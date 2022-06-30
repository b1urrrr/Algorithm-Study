/*
 * @author Minyeong Park
 * @date 2022.06.30.
 * 구간 합 구하기 4
 * 참고 : https://www.acmicpc.net/board/view/85860
 * 문제 링크 : https://www.acmicpc.net/problem/11659
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sum_arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum_arr[i] = sum_arr[i-1] + Integer.parseInt(st.nextToken()); // 누적합을 저장
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int result = sum_arr[j] - sum_arr[i-1];
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}