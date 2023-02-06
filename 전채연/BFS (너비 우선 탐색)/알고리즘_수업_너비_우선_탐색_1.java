/*
    백준 24444번 : 알고리즘 수업 - 너비 우선 탐색 1
    - 문제 유형 : 그래프 이론, 그래프 탐색, 정렬, 너비 우선 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 알고리즘_수업_너비_우선_탐색_1 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] visited;

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        int count = 1; // 방문 순서 저장 변수
        que.add(start);
        visited[start] = count++;

        while (!que.isEmpty()) {
            int node = que.remove();
            for (int i = 0; i < graph.get(node).size(); i++) {
                if (visited[graph.get(node).get(i)] == 0) {
                    que.add(graph.get(node).get(i));
                    visited[graph.get(node).get(i)] = count++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 간선의 수 M 입력
        int R = Integer.parseInt(st.nextToken()); // 시작 정점 R 입력
        visited = new int[N + 1];

        // 그래프 정점 초기화
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<Integer>());

        // 그래프 간선 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 간선 정보 u 입력
            int v = Integer.parseInt(st.nextToken()); // 간선 정보 v 입력
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 간선 오름차순 정렬
        for (int i = 1; i <= N; i++) Collections.sort(graph.get(i));

        // 너비 우선 탐색 실행
        bfs(R);

        // 정점 i의 방문 순서 출력
        for (int i = 1; i <= N; i++) System.out.println(visited[i]);
    }
}
