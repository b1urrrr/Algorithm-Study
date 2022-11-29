// chap16 Q32 정수 삼각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n16_32 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 1;
        while (count <= n) {
            for (int i = 1; i <= count; i++) {
                arr[count][i] = arr[count][i] + Math.max(arr[count-1][i-1], arr[count-1][i]);
            }
            count++;
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[n][i] > max) {
                max = arr[n][i];
            }
        }
        System.out.println(max);
    }
}