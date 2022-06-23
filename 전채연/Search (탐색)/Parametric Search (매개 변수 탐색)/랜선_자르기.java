/*
    백준 1654번 : 랜선 자르기
    - 문제 유형 : 이분 탐색, 매개 변수 탐색
*/

import java.io.*;
import java.util.StringTokenizer;

public class 랜선_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 오영식이 가지고 있는 랜선의 개수 입력
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수 입력
        int[] lan = new int[K];

        long end = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine()); // 랜선의 길이 입력
            end = Math.max(end, lan[i]);
        }

        // 매개 변수 탐색
        // start + end 값이 int 범위를 벗어날 수 있으므로 long으로 선언
        long result = 0;
        long start = 0;
        while (start <= end) {
            long mid = (start + end) / 2; // 랜선을 자르는 길이
            long total = 0;
            for (int i = 0; i < K; i++) {
                total += lan[i] / mid;
            }

            // 랜선의 개수가 부족하면 길이 감소
            if (total < N) end = mid - 1;
            // 랜선의 개수가 충분하면 길이 증가
            else {
                result = Math.max(result, mid);
                start = mid + 1;
            }
        }

        // N개를 만들 수 있는 랜선의 최대 길이 출력
        System.out.println(result);
    }
}
