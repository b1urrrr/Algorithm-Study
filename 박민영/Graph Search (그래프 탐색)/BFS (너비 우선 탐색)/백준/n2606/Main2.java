/*
 * @author Minyeong Park
 * @date 2022.07.01.
 * 바이러스 (DFS & 인접행렬 코드 공부)
 * 문제 링크 : https://www.acmicpc.net/problem/2606
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] arr;
    static boolean[] visited;
    static int count = 0;
    static int node, edge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        StringTokenizer st;
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(1);

        System.out.println(count - 1); // 1번 노드는 제외해야 함
    }
    static void dfs(int start) {
        visited[start] = true;
        count++;
        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }
}