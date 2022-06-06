package chap05;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;

public class Practice5_10 {
    static int n, m; // 세로, 가로 길이
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 그래프 (distance 표현이 아니라면 배열로 구현하는 것이 바람직한 듯)
    static boolean[][] visited; // 방문 여부

    static void dfs (int x, int y) {
        visited[x][y] = true;

        // x + 1, y
        if (x + 1 < n && !visited[x + 1][y] && graph.get(x + 1).get(y) == 0) dfs(x + 1, y);
        // x - 1, y
        if (x - 1 >= 0 && !visited[x - 1][y] && graph.get(x - 1).get(y) == 0) dfs(x - 1, y);
        // x, y + 1
        if (y + 1 < m && !visited[x][y + 1] && graph.get(x).get(y + 1) == 0) dfs(x, y + 1);
        // x, y - 1
        if (y - 1 >= 0 && !visited[x][y - 1] && graph.get(x).get(y - 1) == 0) dfs(x, y - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로 길이 입력
        m = Integer.parseInt(st.nextToken()); // 가로 길이 입력
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph.get(i).add(s.charAt(j) - '0');
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph.get(i).get(j) == 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
