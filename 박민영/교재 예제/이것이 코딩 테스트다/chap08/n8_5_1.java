// chap08 (2) 실전문제 : 1로 만들기
// 제한시간 내에 못 풀고 막혀서 원리 보면서 해결함.
import java.util.Scanner;

public class n8_5_1 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        dp = new int[x + 1];
        for (int i = 2; i <= x; i++) {
            int n5 = i / 5 > 0 ? dp[i/5] : 30001;
            int n3 = i / 3 > 0 ? dp[i/3] : 30001;
            int n2 = i / 2 > 0 ? dp[i/2] : 30001;
            int n1 = i - 1 > 0 ? dp[i-1] : 30001;

            dp[i] = Math.min(n5,Math.min(n3,Math.min(n2,n1))) + 1;
        }
        System.out.println(dp[x]);
    }
}
