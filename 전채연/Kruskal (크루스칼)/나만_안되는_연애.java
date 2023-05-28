/*
    백준 14621번 : 나만 안되는 연애
    - 문제 유형 : 그래프 이론, 최소 스패닝 트리
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 나만_안되는_연애 {
    static int[] parent;

    static class Road implements Comparable<Road> {
        int u;
        int v;
        int d;

        public Road(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Road other) {
            return this.d - other.d;
        }
    }

    static int findParent(int road) {
        if (road == parent[road]) return road;
        return parent[road] = findParent(parent[road]);
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
        int N = Integer.parseInt(st.nextToken()); // 학교의 수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수 M 입력
        parent = new int[N + 1];
        String[] gender = new String[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            gender[i] = st.nextToken();
        }

        ArrayList<Road> roads = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 학교 u의 번호 입력
            int v = Integer.parseInt(st.nextToken()); // 학교 v의 번호 입력
            int d = Integer.parseInt(st.nextToken()); // 거리 d 입력
            if (gender[u].equals(gender[v])) continue;
            roads.add(new Road(u, v, d));
        }

        Collections.sort(roads);

        int count = 0;
        int distance = 0;
        for (int i = 0; i < roads.size(); i++) {
            Road road = roads.get(i);
            if (findParent(road.u) != findParent(road.v)) {
                union(road.u, road.v);
                count++;
                distance += road.d;
            }
        }

        // 깽미가 만든 앱의 경로 길이 출력
        System.out.println(count < N - 1 ? -1 : distance);
    }
}
