/*
    백준 4386번 : 별자리 만들기
    - 문제 유형 : 그래프 이론, 최소 스패닝 트리
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 별자리_만들기 {
    static int[] parent;

    static class Star {
        int index;
        float x;
        float y;

        public Star(int index, float x, float y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int starA;
        int starB;
        float distance;

        public Edge(int starA, int starB, float distance) {
            this.starA = starA;
            this.starB = starB;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge other) {
            if (this.distance > other.distance) return 1;
            else if (this.distance < other.distance) return -1;
            return 0;
        }
    }

    /** 두 별 사이의 거리 반환 */
    static float getDistance(Star star1, Star star2) {
        return (float) Math.sqrt(Math.pow(star1.x - star2.x, 2) + Math.pow(star1.y - star2.y, 2));
    }

    /** 부모 별 인덱스 반환 */
    static int findParent(int starIndex) {
        if (parent[starIndex] == starIndex) return starIndex;
        return parent[starIndex] = findParent(parent[starIndex]);
    }

    /** 별 합집합 연산 수행 */
    static void union(int starA, int starB) {
        starA = findParent(starA);
        starB = findParent(starB);

        if (starA < starB) parent[starB] = starA;
        else parent[starA] = starB;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 별의 개수 n 입력
        parent = new int[n];
        Star[] stars = new Star[n];

        // 부모 테이블 초기화 및 별 정보 입력
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            float x = Float.parseFloat(st.nextToken()); // 별의 x 좌표 입력
            float y = Float.parseFloat(st.nextToken()); // 별의 y 좌표 입력
            stars[i] = new Star(i, x, y);
        }

        // 두 별에 대한 간선 정보 정리
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(stars[i].index, stars[j].index, getDistance(stars[i], stars[j])));
            }
        }

        // 거리 기준으로 간선 오름차순 정렬
        Collections.sort(edges);

        float total = 0;
        for (Edge edge : edges) {
            if (findParent(edge.starA) != findParent(edge.starB)) {
                union(edge.starA, edge.starB);
                total += edge.distance;
            }
        }

        // 별자리를 만드는 최소 비용 출력
        System.out.printf("%.2f\n", total);
    }
}
