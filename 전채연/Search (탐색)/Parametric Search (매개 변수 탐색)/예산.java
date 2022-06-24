/*
    백준 2512번 : 예산
    - 문제 유형 : 이분 탐색, 매개 변수 탐색
*/

import java.io.*;
import java.util.StringTokenizer;

public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 지방의 수 입력 (3 이상 10,000 이하)
        int[] budget = new int[N];

        int end = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken()); // 각 지방의 예산 요청 입력 (1 이상 100,000 이하)
            end = Math.max(end, budget[i]);
        }
        int M = Integer.parseInt(br.readLine()); // 총 예산 (N 이상 1,000,000,000 이하)

        // 매개 변수 탐색
        int start = 1;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int total = 0; // 최대값이 1,000,000,000이므로 int로 선언 (10,000 * 100,000)
            for (int i = 0; i < N; i++) {
                if (budget[i] < mid) total += budget[i];
                else total += mid;
            }

            // 배정 예산이 너무 많으면 상한액 감소
            if (total > M) end = mid - 1;
            // 배정 예산이 지급 가능하면 상한액 증가
            else {
                result = Math.max(result, mid);
                start = mid + 1;
            }
        }

        // 배정된 예산들 중 최대값 정수 출력
        System.out.println(result);
    }
}
