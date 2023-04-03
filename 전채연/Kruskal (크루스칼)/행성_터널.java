/*
    백준 2887번 : 행성 터널
    - 문제 유형 : 그래프 이론, 정렬, 최소 스패닝 트리
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 행성_터널 {
    static int[] parent;

    static class Planet {
        int index;
        int x;
        int y;
        int z;

        public Planet(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int planetA;
        int planetB;
        long cost;

        public Edge(int planetA, int planetB, long cost) {
            this.planetA = planetA;
            this.planetB = planetB;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            if (this.cost > other.cost) return 1;
            else if (this.cost < other.cost) return -1;
            return 0;
        }
    }

    /** 두 수의 차 반환 */
    static long getDifference(long n1, long n2) {
        return Math.abs(n1 - n2);
    }

    /** 행성 터널을 연결하는 데 드는 비용 반환 */
    static long getCost(Planet p1, Planet p2) {
        return Math.min(Math.min(getDifference(p1.x, p2.x), getDifference(p1.y, p2.y)), getDifference(p1.z, p2.z));
    }

    /** 부모 행성 반환 */
    static int findParent(int planet) {
        if (parent[planet] == planet) return planet;
        return parent[planet] = findParent(parent[planet]);
    }

    /** 합집합 연산 수행 */
    static void union(int planetA, int planetB) {
        planetA = findParent(planetA);
        planetB = findParent(planetB);

        if (planetA < planetB) parent[planetB] = planetA;
        else parent[planetA] = planetB;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 행성의 개수 N 입력
        parent = new int[N];
        Planet[] planets = new Planet[N];
        List<Edge> edges = new ArrayList<>();

        // 부모 테이블 초기화 및 행성 좌표 입력
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 행성의 x좌표 입력
            int y = Integer.parseInt(st.nextToken()); // 행성의 y좌표 입력
            int z = Integer.parseInt(st.nextToken()); // 행성의 z좌표 입력
            planets[i] = new Planet(i, x, y, z);
        }

        // x축에 대해 행성 터널 연결 비용 처리
        Arrays.sort(planets, (p1, p2) -> p1.x - p2.x);
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(planets[i].index, planets[i + 1].index, getCost(planets[i], planets[i + 1])));
        }

        // y축에 대해 행성 터널 연결 비용 처리
        Arrays.sort(planets, (p1, p2) -> p1.y - p2.y);
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(planets[i].index, planets[i + 1].index, getCost(planets[i], planets[i + 1])));
        }

        // z축에 대해 행성 터널 연결 비용 처리
        Arrays.sort(planets, (p1, p2) -> p1.z - p2.z);
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(planets[i].index, planets[i + 1].index, getCost(planets[i], planets[i + 1])));
        }

        // 연결 비용을 기준으로 행성 터널 오름차순 정렬 
        Collections.sort(edges);

        long total = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge next = edges.get(i);
            if (findParent(next.planetA) != findParent(next.planetB)) {
                union(next.planetA, next.planetB);
                total += next.cost;
            }
        }

        // 모든 행성을 터널로 연결하는데 필요한 최소 비용 출력
        System.out.println(total);
    }
}
