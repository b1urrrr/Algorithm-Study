/*
    백준 2805번 : 나무 자르기
    - 문제 유형 : 이분 탐색, 매개 변수 탐색
*/

import java.io.*;
import java.util.StringTokenizer;

public class 나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수 입력
        int M = Integer.parseInt(st.nextToken()); // 상근이가 집으로 가져가려는 나무의 길이 입력
        int[] logs = new int[N];

        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            logs[i] = Integer.parseInt(st.nextToken()); // 나무의 길이 입력
            end = Math.max(end, logs[i]);
        }

        // 매개 변수 탐색
        int result = 0;
        int start = 0;
        while (start <= end) {
            int mid = (start + end) / 2; // 나무를 자르는 높이
            long total = 0;
            for (int i = 0; i < N; i++) {
                if (logs[i] > mid) total += logs[i] - mid;
            }

            // 나무의 길이가 부족한 경우 자르는 높이 감소
            if (total < M) end = mid - 1;
            // 나무의 길이가 충분한 경우 자르는 높이 증가
            else {
                result = Math.max(result, mid);
                start = mid + 1;
            }
        }

        // 최소 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값 출력
        System.out.println(result);
    }    
}