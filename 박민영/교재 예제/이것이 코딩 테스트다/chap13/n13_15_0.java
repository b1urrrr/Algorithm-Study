// chap13 Q.15 특정 거리의 도시 찾기
// DFS로 풀어보았는데 예제는 잘 돌아가지만.. 시간초과가 떴다..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n13_1_0 {
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }

        distance = new int[n+1];
        Arrays.fill(distance, 300001);
        visited = new boolean[n+1];
        dfs(x, 0);

        boolean is_printed = false;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                is_printed = true;
                continue;
            }
            if (i == distance.length - 1 && !is_printed) {
                System.out.println(-1);
            }
        }
    }

    static void dfs(int start, int depth) {
        visited[start] = true;
        distance[start] = Math.min(depth, distance[start]);
        for (int next : lists[start]) {
            if (!visited[next]) {
                dfs(next, depth+1);
            }
        }
        visited[start] = false;
    }
}
