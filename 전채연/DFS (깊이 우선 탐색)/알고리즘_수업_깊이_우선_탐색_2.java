/*
    백준 24480번 : 알고리즘 수업 - 깊이 우선 탐색 2
    - 문제 유형 : 그래프 이론, 그래프 탐색, 정렬, 깊이 우선 탐색
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 알고리즘_수업_깊이_우선_탐색_2 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] visited;
    static int count = 1;

    // 깊이 우선 탐색 함수
    public static void dfs(int start) {
        visited[start] = count++; // 시작 정점 방문 표시
        
        // 시작 정점의 인접 정점 집합 오름차순 방문
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (visited[graph.get(start).get(i)] == 0) dfs(graph.get(start).get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 수 n 입력
        int m = Integer.parseInt(st.nextToken()); // 간선의 수 m 입력
        int r = Integer.parseInt(st.nextToken()); // 시작 정점 r 입력

        // 그래프 초기화
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<Integer>());
        visited = new int[n + 1];

        // 간선 정보 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 정점 u 입력
            int v = Integer.parseInt(st.nextToken()); // 정점 v 입력
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 간선 내림차순 정렬
        for (int i = 1; i <= n; i++) Collections.sort(graph.get(i), Collections.reverseOrder());

        // 깊이 우선 탐색 실행
        dfs(r);

        // 정점 i의 방문 순서 출력
        for (int i = 1; i <= n; i++) System.out.println(visited[i]);
    }
}
