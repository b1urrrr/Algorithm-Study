// chap10 (3) 실전 문제 : 도시 분할 계획
// 아이디어에서부터 막혀서... 해설을 보면서 이해하면서 공부하는 식으로 풀었다..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    private int distance;
    private int nodeA;
    private int nodeB;


    public Edge(int distance, int nodeA, int nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.distance = distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge o) {
        if (this.distance < o.distance) return -1;
        else if (this.distance > o.distance) return 1;
        else return 0;
    }
}

public class n10_8 {
    static int n, m;
    static int[] parent = new int[100001]; // 부모 테이블 초기화
    static ArrayList<Edge> edges = new ArrayList<>(); // 모든 간선을 담을 리스트
    static int result = 0; // 최종 비용을 담을 변수

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            // 비용 순으로 정렬하기 위해서 첫 번째 원소를 비용으로 설정
            edges.add(new Edge(distance, a, b));
        }

        // 간선을 비용 순으로 정렬
        Collections.sort(edges);
        int last = 0; // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선

        // 간선을 하나씩 확인
        for (int i = 0; i < edges.size(); i++) {
            int distance = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a,b);
                result += distance;
                last = distance;
            }
        }

        System.out.println(result - last);
    }
}
