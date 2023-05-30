/*
    백준 1774번 : 우주신과의 교감
    - 문제 유형 : 그래프 이론, 최소 스패닝 트리
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 우주신과의_교감 {
    static int[] parent;

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getDistance(Coordinate other) {
            return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        }
    }

    static class Edge implements Comparable<Edge> {
        int godA;
        int godB;
        double distance;

        public Edge(int a, int b, double distance) {
            this.godA = a;
            this.godB = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    static int findParent(int god) {
        if (god == parent[god]) return god;
        return parent[god] = findParent(parent[god]);
    }

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 우주신들의 개수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 이미 연결된 신들과의 통로의 개수 M 입력
        parent = new int[N + 1];
        Coordinate[] coordinates = new Coordinate[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 우주신의 x 좌표 입력
            int y = Integer.parseInt(st.nextToken()); // 우주신의 y 좌표 입력
            coordinates[i] = new Coordinate(x, y);
            parent[i] = i;
        }

        // 통로 길이 계산
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                edges.add(new Edge(i, j, coordinates[i].getDistance(coordinates[j])));
            }
        }

        // 이미 연결된 통로 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        Collections.sort(edges);
        Double sum = 0.0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (findParent(edge.godA) != findParent(edge.godB)) {
                union(edge.godA, edge.godB);
                sum += edge.distance;
            }
        }

        // 만들어야 할 최소의 통로 길이 소수점 둘째짜리까지 출력
        System.out.printf("%.2f\n", sum);
    }
}
