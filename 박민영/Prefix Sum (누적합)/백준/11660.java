/*
 * @author Minyeong Park
 * @date 2023.03.05.
 * 구간 합 구하기 5
 * 문제 링크 : https://www.acmicpc.net/problem/11660
 */



import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken()); // 행 별로 누적합 저장
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int x = x1; x <= x2; x++) {
                sum += arr[x][y2] - arr[x][y1-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}