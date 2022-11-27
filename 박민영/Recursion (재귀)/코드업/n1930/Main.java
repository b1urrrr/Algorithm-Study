/*
 * @author Minyeong Park
 * @date 2022.11.27.
 * SuperSum
 * 원리 및 코드 참고 : https://kong-ambition09.tistory.com/27
 * 문제 링크 : https://codeup.kr/problem.php?id=1930
 */


import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int k, n;
    static int[][] dp = new int[15][15];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            k = sc.nextInt();
            n = sc.nextInt();

            init();

            System.out.println(supersum(k, n));
        }
    }

    static int supersum(int k_, int n_) {
        int result = 0;
        if (dp[k_][n_] > 0)
            return dp[k_][n_];
        else {
            for (int i = 1; i <= n_; i++) {
                result += supersum(k_-1, i);
            }
            dp[k_][n_] = result;
            return result;
        }
    }

    static void init() {
        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }
    }
}