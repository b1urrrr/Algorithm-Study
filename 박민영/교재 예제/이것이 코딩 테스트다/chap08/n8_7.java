// chap08 (4) 실전문제 : 바닥 공사
// 전에 풀어봤던 것과 비슷하지만.. 또 틀려서... 해설 보면서 이해함...
import java.util.Scanner;

public class n8_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 796796;
        }
        System.out.println(dp[n]);
    }
}
