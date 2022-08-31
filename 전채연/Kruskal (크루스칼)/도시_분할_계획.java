/*
    백준 1647번 : 도시 분할 계획
    - 문제 유형 : 그래프 이론, 최소 스패닝 트리
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 도시_분할_계획 {
    static int[] parent; // 부모 테이블
    static ArrayList<Edge> edges = new ArrayList<>(); // 간선 리스트

    static class Edge implements Comparable<Edge> {
        int cost;
        int nodeA;
        int nodeB;

        public Edge(int cost, int nodeA, int nodeB) {
            this.cost = cost;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        // sort 메서드를 사용하는 경우 0까지 처리 필요
        @Override
        public int compareTo(Edge other) {
            if (this.cost < other.cost) return -1;
            else if (this.cost > other.cost) return 1;
            else return 0;
        }
    }

    // 루트 노드 탐색 함수
    static int find(int a) {
        if (a == parent[a]) return a;
        // 경로 압축 기법 사용
        return parent[a] = find(parent[a]);
    }

    // 노드 합치기 함수
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 길의 개수 M 입력
        parent = new int[N + 1];

        // 부모 테이블 자기 자신으로 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 간선의 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 집1 번호 입력
            int B = Integer.parseInt(st.nextToken()); // 집2 번호 입력
            int C = Integer.parseInt(st.nextToken()); // A와 B를 연결하는 길의 유지비 입력
            edges.add(new Edge(C, A, B));
        }

        // 간선들을 유지비 기준 오름차순으로 정렬
        Collections.sort(edges);

        int total = 0; // 유지비의 합
        int count = 0; // 연결된 길의 개수
        for (int i = 0; i < edges.size(); i++) {
            // 연결된 길이 N - 2개면 종료
            if (count == N - 2) break;

            int a = edges.get(i).nodeA;
            int b = edges.get(i).nodeB;
            int cost = edges.get(i).cost;

            // 사이클이 존재하지 않는 경우 길 연결
            if (find(a) != find(b)) {
                union(a, b);
                total += cost;
                count++;
            }
        }

        // 없애고 남은 길 유지비의 합의 최솟값 출력
        System.out.println(total);
    }
}
