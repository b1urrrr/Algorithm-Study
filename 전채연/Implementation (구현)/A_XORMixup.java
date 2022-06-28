import java.io.*;
import java.util.StringTokenizer;

public class A_XORMixup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        TEST : for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 정수의 개수
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < n; j++) {
                int x = arr[j];
                int result = -1;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    if (result == -1) result = arr[k];
                    else result = result ^ arr[k];
                }
                if (x == result) {
                    System.out.println(x);
                    continue TEST;
                }
            }
        }
    }
}