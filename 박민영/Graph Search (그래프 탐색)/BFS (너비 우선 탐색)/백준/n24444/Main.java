/*
 * @author Minyeong Park
 * @date 2022.06.10.
 * 알고리즘 수업 - 너비 우선 탐색 1
 * 문제 링크 : https://www.acmicpc.net/problem/24444
 */

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] answer;
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        bfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int r) {
        for (int i = 1; i <= list.length - 1; i++) {
            if (i != r)
                visited[i] = false;
        }
        visited[r] = true;
        queue.offer(r);
        answer[r] = ++index;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i : list[u]) {
                if (visited[i] == false) {
                    visited[i] = true;
                    queue.offer(i);
                    answer[i] = ++index;
                }
            }
        }
    }
}