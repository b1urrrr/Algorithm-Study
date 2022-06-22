package chap07;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Practice7_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 떡의 개수
        int m = Integer.parseInt(st.nextToken()); // 요청한 떡의 길이
        int end = 0;
        int[] length = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            length[i] = Integer.parseInt(st.nextToken()); // 떡의 길이 입력
            end = Math.max(end, length[i]);
        }

        // 0 ~ 떡 길이의 최대값에 대해 이진탐색 진행
        int result = 0;
        int start = 0;
        while (start <= end) {
            int mid = (start + end) / 2; // 떡을 자르는 높이
            // 손님이 가져가는 떡의 길이 계산
            int total = 0;
            for (int i = 0; i < n; i++) {
                if (length[i] > mid) {
                    total += length[i] - mid;
                }
            }

            // 손님이 요청한 길이보다 짧으면 높이 감소
            if (total < m) end = mid - 1;
            // 손님이 요쳥한 길이보다 같거나 길면 높이 증가
            else {
                // 최대값 저장
                result = Math.max(mid, result);
                start = mid + 1;
            }
        }

        // 절단기에 설정할 수 있는 높이의 최대값 출력
        System.out.println(result);
    }
}
