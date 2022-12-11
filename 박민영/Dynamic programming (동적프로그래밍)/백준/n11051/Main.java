/*
 * @author Minyeong Park
 * @date 2022.12.10.
 * 이항 계수 2
 * 원리 및 코드 참고 : https://rh-tn.tistory.com/32
 * 문제 링크 : https://www.acmicpc.net/problem/11051
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        System.out.println(func(n,k));
    }

    static int func(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }
        if (dp[n][k] == 0)
            dp[n][k] = (func(n-1, k-1) + func(n-1, k)) % 10007;
        return dp[n][k];
    }
}