/*
 * @author Minyeong Park
 * @date 2022.06.17.
 * 알고리즘 수업 - 너비 우선 탐색 2
 * 문제 링크 : https://www.acmicpc.net/problem/24445
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] lists = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(lists[i], Collections.reverseOrder());
        }

        int[] answer = new int[n+1];
        boolean[] visited = new boolean[n+1];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(r);
        visited[r] = true;
        while (!queue.isEmpty()) {
            int visited_node = queue.poll();
            answer[visited_node] = ++index;
            for (int next : lists[visited_node]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
}