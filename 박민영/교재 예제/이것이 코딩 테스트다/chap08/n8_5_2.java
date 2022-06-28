// chap08 (2) 실전문제 : 1로 만들기 (해설 코드)
// 제한시간 내에 못 풀고 막혀서 원리 보면서 해결함.
import java.util.Scanner;

public class n8_5_2 {
    static int[] dp =  new int[30001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        // 동적 프로그래밍 진행 (보텀업)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;

            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i/2]+1);

            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i/3]+1);

            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                dp[i] = Math.min(dp[i], dp[i/5]+1);
        }
        System.out.println(dp[x]);
    }
}
