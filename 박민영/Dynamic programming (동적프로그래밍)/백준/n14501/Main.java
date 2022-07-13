/*
 * @author Minyeong Park
 * @date 2022.07.13.
 * 퇴사
 * 참고 : https://hidelookit.tistory.com/118, https://kjs-dev.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%9E%90%EB%B0%94-14501-%ED%87%B4%EC%82%AC
 * 문제 링크 : https://www.acmicpc.net/problem/14501
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] day;
    static int[] pay;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        day = new int[n+1];
        pay = new int[n+1];
        dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        // 현재 날짜에서 소요 시간과 비용을 더해 dp[다음 가능한 날 인덱스] 에 저장한다.
        // 이후 중복될 때 최댓값을 넣는다.
        for (int i = 0; i < n; i++) {
            if (i + day[i] <= n) { // 날짜가 범위를 넘어가지 않는 경우
                dp[i + day[i]] = Math.max(dp[i + day[i]], dp[i] + pay[i]);
            }
            // 현재 경우의 수가 0일 수 있기 때문에 이전의 최댓값을 넣어줌.
            // 해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 함.
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}