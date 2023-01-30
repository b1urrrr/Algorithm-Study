/*
 * @author Minyeong Park
 * @date 2023.01.28.
 * DFS와 BFS (다른 풀이 공부 - 책 기본 설명 참고하면서 조금 리팩토링)
 * 참고 : 이코테 책 기본 설명 참고함
 * 문제 링크 : https://www.acmicpc.net/problem/1260
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visited_dfs = new boolean[n+1];
        visited_bfs = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }

    static void dfs(int start) {
        visited_dfs[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < list.get(start).size(); i++) {
            int node = list.get(start).get(i);
            if (!visited_dfs[node]) {
                dfs(node);
            }
        }
    }

    static void bfs(int start) {
        visited_bfs[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < list.get(node).size(); i++) {
                int next_node = list.get(node).get(i);
                if (!visited_bfs[next_node]) {
                    visited_bfs[next_node] = true;
                    queue.offer(next_node);
                }
            }
        }
    }
}