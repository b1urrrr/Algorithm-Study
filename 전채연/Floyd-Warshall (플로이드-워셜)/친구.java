/*
    백준 1058번 : 친구
    - 문제 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 친구 {
    static int MAX = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int[] count = new int[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = (s.charAt(j) == 'Y') ? 1 : MAX;
            }
            graph[i][i] = 0;
        }

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                for (int i = 0; i < N; i++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] <= 2) count[i]++;
            }
        }

        Arrays.sort(count);
        System.out.println(count[N - 1] - 1);
    }
}