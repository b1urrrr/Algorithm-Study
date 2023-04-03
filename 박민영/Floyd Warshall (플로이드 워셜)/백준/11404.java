/*
 * @author Minyeong Park
 * @date 2023.03.27.
 * 플로이드
 * 코드 개선 참고 : https://steady-coding.tistory.com/96, https://bbangson.tistory.com/108
 * 문제 링크 : https://www.acmicpc.net/problem/11404
 */


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int INF = 10000001; // Integer.MAX_VALUE로 설정하면 안 됨! (오버플로우 발생 가능함) // INF는 100000(가중치의 최댓값) * 99 (정점개수는 최대 100개)

        int[][] d = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], INF);
        }
        for (int i = 1; i <= n; i++) {
            d[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (d[s][e] > d[s][k] + d[k][e]) {
                        d[s][e] = d[s][k] + d[k][e];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == INF) {
                    sb.append(0 + " ");
                } else {
                    sb.append(d[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}