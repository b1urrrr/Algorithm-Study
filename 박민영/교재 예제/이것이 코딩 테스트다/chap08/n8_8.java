// chap08 (5) 실전문제 : 효율적인 화폐 구성 시작
// 너무 모르겠어서... 해설 보면서 이해함... 나중에 다시 풀기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n8_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[m+1];
        for (int i = 0; i < m; i++) {
            dp[i] = 10001;
        }

        dp[0] = 0; // 0원은 화폐를 하나도 사용하지 않았을 때 만들 수 있음.
        for (int i = 0; i < n; i++) { // 각 화폐 단위에 대해 진행
            for (int j = arr[i]; j <= m; j++) { // 각 화폐 단위가 최소이므로 arr[i]부터 시작 ~
                if (dp[j - arr[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        if (dp[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }
}
