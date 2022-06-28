// chap08 (3) 실전문제 : 개미 전사
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n8_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rooms = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = rooms[0];
        dp[1] = Math.max(dp[0], rooms[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + rooms[i], dp[i-1]);
        }
        System.out.println(dp[n-1]);
    }
}