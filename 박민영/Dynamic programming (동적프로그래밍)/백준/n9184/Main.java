/*
 * @author Minyeong Park
 * @date 2022.05.01.
 * 신나는 함수 실행
 * 출처 : https://st-lab.tistory.com/190
 * 문제 링크 : https://www.acmicpc.net/problem/9184
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[21][21][21]; // a,b,c 중 20이 넘어가게 되면 w(20,20,20)을 호출하고, 0이하이면 1을 반환하므로 각 배열의 크기는 21(0 ~ 20)을 넘기지 않는다
    static int w(int a, int b, int c) {
        // 이미 계산되어 저장되어 있는 경우 해당 값을 바로 반환
        if (inRange(a,b,c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if (a > 20 || b > 20 || c > 20)
            return dp[20][20][20] = w(20,20,20);
        else if (a < b && b < c)
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a,b-1, c);
        else
            return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a,b,c;
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
        }
        System.out.println(sb);
    }
}