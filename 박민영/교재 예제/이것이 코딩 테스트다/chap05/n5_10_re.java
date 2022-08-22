// chap05 (3) 실전 문제 : 음료수 얼려 먹기 - 다시 풀기 진행
// 또 막혀서... 해설 원리 보면서 풀려고 했는데 막혔다...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n5_10_re {
    static int n, m;
    static int[][] graph = new int[1000][1000]; // 원래 1인 것은 1로 두고, 방문한 것은 1로 만든다!!
    static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;

        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;

            // 상하좌우의 위치들도 모두 재귀적으로 호출
            // 이때 상하좌우에서 0인 칸들을 모두 1로 바꾸면서 방문한 것으로 한번에 처리하고, 연결된 칸들을 한 칸으로 본다.
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);

            return true; // 이 칸은 0인 칸이였으니까 true를 리턴
        }
        return false; // 이 칸은 1인 칸이였으니까 false를 리턴
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int count = 0;
        for (int i = 0; i  < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j))
                    count += 1;
            }
        }
        System.out.println(count);
    }
}