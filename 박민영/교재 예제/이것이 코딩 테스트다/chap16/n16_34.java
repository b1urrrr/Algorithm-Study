import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class n16_34 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> v = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v.add(Integer.parseInt(st.nextToken()));
        }
        // 15 11 4 8 5 2 4 순서로 있는 상태

        // 순서를 뒤집어 '가장 긴 증가하는 부분 수열' 문제로 전환
        // 4 2 5 8 4 11 15 순서로 있는 상태
        Collections.reverse(v);

        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (v.get(j) < v.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // v  : 4 2 5 8 4 11 15
        // dp : 1 1 2 3 2  4  5

        // 열외해야 하는 병사의 최소 수를 출력
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }

        System.out.println(n - maxValue);
        // 예제) 7 - 5 = 2개
    }
}
