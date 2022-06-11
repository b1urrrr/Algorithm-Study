/*
 * @author Minyeong Park
 * @date 2022.06.09.
 * 알고리즘 수업 - 깊이 우선 탐색 2
 * 참고 : https://hianna.tistory.com/569, 24479번 해결했던 풀이
 * 문제 링크 : https://www.acmicpc.net/problem/24480
 */

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] answer;
    static boolean[] visited;
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        answer = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }

        visited[r] = true;
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int r) {
        answer[r] = ++index;
        for (int node : list[r]) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(node);
            }
        }
    }
}