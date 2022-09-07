import java.io.*;
import java.util.*;

public class A_MainakAndArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력 (1 이상 50 이하)

        // 테스트 케이스 반복
        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine()); // 배열 원소의 개수 입력 (1 이상 2000 이하)
            int[] arr = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()); // 배열의 원소 입력 (1 이상 999 이하)
            }

            // 1이 입력되면 0 출력
            if (n == 1) {
                bw.write("0\n");
                continue;
            }

            // a1, an이 바뀌지 않는 경우
            int result = arr[n] - arr[1];

            // a1만 바뀌는 경우
            for (int i = 2; i < n; i++) {
                result = Math.max(result, arr[n] - arr[i]);
            }

            // an만 바뀌는 경우
            for (int i = 2; i < n; i++) {
                result = Math.max(result, arr[i] - arr[1]);
            }

            // a1, an이 바뀌는 경우
            for (int i = 1; i < n; i++) {
                result = Math.max(result, arr[i] - arr[i + 1]);
            }

            // 결과 출력
            bw.write(result + "\n");
        }

        bw.flush();
    }
}
