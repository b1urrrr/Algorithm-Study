/*
    백준 17175번 : 피보나치는 지겨웡~
    - 문제 유형 : 동적 계획법
*/

import java.io.*;

public class 피보나치는_지겨웡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n 입력
        int[] memo = new int[51]; // 메모이제이션 배열

        // n이 0일 때와 1일 때는 1번 호출함.
        memo[0] = memo[1] = 1;

        // n이 i인 경우의 호출 횟수 계산
        for (int i = 2; i <= n; i++) {
            memo[i] = ((memo[i - 1] + memo[i - 2] + 1) % 1000000007);
        }

        // n에 대한 호출 횟수 출력
        System.out.println(memo[n]);
        br.close();
    }
}
