/*
    백준 3079번 : 입국심사
    - 문제 유형 : 이분 탐색, 매개 변수 탐색
*/

import java.io.*;
import java.util.StringTokenizer;

public class 입국심사_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 입국 심사대의 개수 N 입력 (1 이상 100,000 이하)
        int M = Integer.parseInt(st.nextToken()); // 상근이와 친구들의 인원 M 입력 (1 이상 1,000,000,000 이하)
        int[] times = new int[N];

        long end = 0;
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine()); // 각 심사대에서 심사 하는 데 걸리는 시간 입력 (1 이상 1,000,000,000 이하)
            end = Math.max(end, times[i]);
        }

        long start = 1;
        end *= M; // 심사 시간의 최대값 * 인원으로 end 제한
        long result = Long.MAX_VALUE;
        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;
            for (int i = 0; i < N; i++) total += mid / times[i];

            // 심사 가능 인원이 부족한 경우 시간 증가
            if (total < M) start = mid + 1;
            // 심사 가능 인원이 충분한 경우 시간 감소
            else {
                result = Math.min(result, mid);
                end = mid - 1;
            }
        }

        // 상근이와 친구들이 심사를 마치는데 걸리는 시간의 최솟값 출력
        System.out.println(result);
    }
}
