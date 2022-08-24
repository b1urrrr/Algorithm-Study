package chap09;

import java.util.*;

public class Example9_1 {
    // 노드의 개수 n, 간선의 개수 m, 시작 노드 번호 start
    static int n, m, start;
    // 연결 노드 그래프
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 방문 여부 배열
    static boolean[] visited;
    // 최단 거리 테이블
    static int[] d;

    static class Node {
        int index; // 노드 번호
        int distance; // 시작점으로부터의 최단 거리

        Node(int index, int distance) { // 생성자
            this.index = index;
            this.distance = distance;
        }
    } 

    // 최단 거리가 가장 짧은 노드 순차 탐색 후 인덱스 반환 함수
    static int getSmallestNode() {
        int min = Integer.MAX_VALUE;
        int index = 0; // 가장 최단 거리가 짧은 노드의 인덱스
        for (int i = 1; i <= n; i++) {
            if (d[i] < min && !visited[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    // 다익스트라 최단 경로 알고리즘 함수
    static void dijkstra(int start) {
        // 시작 노드 초기화 및 처리
        d[start] = 0;
        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            d[graph.get(start).get(i).index] = graph.get(start).get(i).distance;
        }

        // 나머지 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 최단 거리가 가장 짧은 노드에 대해 방문 처리
            int now = getSmallestNode();
            visited[now] = true;

            // 현재 노드와 연결된 다른 노드의 최단 거리 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).distance;
                // 현재 노드를 거치는 경로가 최단 경로인 경우
                if (cost < d[graph.get(now).get(j).index]) {
                    d[graph.get(now).get(j).index] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드의 개수 n 입력
        m = sc.nextInt(); // 간선의 개수 m 입력
        start = sc.nextInt(); // 시작 노드의 번호 입력
        visited = new boolean[n + 1];
        d = new int[n + 1];

        // 연결 노드 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 간선 정보(노드 간 거리) 입력
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt(); // 시작 노드
            int to = sc.nextInt(); // 종료 노드
            int distance = sc.nextInt(); // 거리
            graph.get(from).add(new Node(to, distance));
        }

        // 최단 거리 테이블 초기화 (무한)
        Arrays.fill(d, Integer.MAX_VALUE);

        // 다익스트라 최단 경로 알고리즘 실행
        dijkstra(start);

        // 모든 노드로의 최단 거리 출력
        for (int i = 1; i <= n; i++) {
            // 연결되지 않은 경우 'INFINITY' 출력
            if (d[i] == Integer.MAX_VALUE) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }
    }
}