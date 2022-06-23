/*
 * @author Minyeong Park
 * @date 2022.06.23.
 * 가장 긴 감소하는 부분 수열 (반복문 Bottom-Up)
 * 참고 : https://st-lab.tistory.com/137 (11053번 가장 긴 증가하는 부분 수열 문제 풀이 설명)
 * 문제 링크 : https://www.acmicpc.net/problem/11722
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 내가 작성한 코드에서는 dp를 오름차순으로 정렬하고 n-1인덱스 값을 출력했는데, 이렇게 변형시키지 말고 그냥 직접 max값을 찾는 게 더 좋을 것 같다.
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}