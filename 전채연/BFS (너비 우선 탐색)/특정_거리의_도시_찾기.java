/*
    백준 18352번 : 특정 거리의 도시 찾기
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 특정_거리의_도시_찾기 {
    static int N, M; // 도시의 개수 N, 도로의 개수 M
    static boolean[] visited;
    static int[] distance;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // 너비 우선 탐색 메서드
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()) {
            int node = que.remove();

            for (int i = 0; i < graph.get(node).size(); i++) {
                // 아직 방문하지 않은 도시면 거리 갱신 및 큐에 추가
                if (!visited[graph.get(node).get(i)]) {
                    distance[graph.get(node).get(i)] = distance[node] + 1;
                    visited[graph.get(node).get(i)] = true;
                    que.add(graph.get(node).get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수 N 입력
        M = Integer.parseInt(st.nextToken()); // 도로의 개수 M 입력
        int K = Integer.parseInt(st.nextToken()); // 거리 정보 K 입력
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호 X 입력
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        // 그래프 및 거리 배열 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            if (i == X) distance[i] = 0;
            else distance[i] = Integer.MAX_VALUE;
        }

        // 도로 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 출발 도시의 번호 A 입력
            int B = Integer.parseInt(st.nextToken()); // 도착 도시의 번호 B 입력
            graph.get(A).add(B);
        }

        // 너비 우선 탐색 수행
        bfs(X);

        // 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력
        boolean none = true;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.print(i + " ");
                none = false;
            }
        }
        // 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력
        if (none) System.out.print("-1");
        System.out.println();
    }
}