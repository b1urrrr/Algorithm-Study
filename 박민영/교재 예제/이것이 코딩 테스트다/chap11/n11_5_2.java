// chap11 Q5. 볼링공 고르기 (해설 코드)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n11_5_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1부터 10까지의 무게를 담을 수 있는 배열
        int[] arr = new int[11];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[x] += 1;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            n -= arr[i]; // 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외
            result += arr[i] * n; // B가 선택하는 경우의 수와 곱해주기
        }
        System.out.println(result);
    }
}
