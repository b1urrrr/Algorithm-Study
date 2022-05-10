import java.io.*;

public class IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // N 입력
        int m = Integer.parseInt(br.readLine()); // M 입력
        char[] data = br.readLine().toCharArray(); // S 입력

        int[] memo = new int[m];
        int ans = 0;

        for (int i = 1; i < m - 1; i++) {
            if (data[i] == 'O' && data[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;

                if (memo[i + 1] >= n && data[i - 2 * n + 1] == 'I')
                    ans++;
            }
        }
        
        // 결과 출력
        System.out.println(ans);
    }
}
