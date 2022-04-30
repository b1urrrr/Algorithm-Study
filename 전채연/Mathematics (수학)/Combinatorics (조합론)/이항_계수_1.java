/*
    백준 11050번 : 이항 계수 1
    - 문제 유형 : 수학, 조합론
*/

import java.io.*;
import java.util.StringTokenizer;

public class 이항_계수_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken()); // N 입력
        int K = Integer.parseInt(st.nextToken()); // K 입력
        int result = 1; // 계산 결과

        if (0 <= K && K <= N) {
            // N부터 N - K + 1까지 곱함
            for (int i = N; i > N - K && i > 1; i--) {
                if (i == N) {
                    result = N;
                    continue;
                } 
                result *= i;
            }

            // K부터 1까지 나눔 (1 생략)
            for (int i = K; i > 1; i--)
                result /= i;
        } else {
            result = 0;
        }

        // 결과 출력
        System.out.println(result);
        br.close();
    }
}