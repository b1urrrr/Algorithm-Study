/*
    백준 1939번 : 중량제한
    - 문제 유형 : 자료 구조, 그래프 이론, 그래프 탐색, 이분 탐색, 너비 우선 탐색, 분리 집합
    - 풀이 유형 : 크루스칼
*/

import java.io.*;
import java.util.*;

public class 중량제한 {
    static int[] parent;

    static class Bridge implements Comparable<Bridge> {
        int islandA;
        int islandB;
        int limit;

        public Bridge(int islandA, int islandB, int limit) {
            this.islandA = islandA;
            this.islandB = islandB;
            this.limit = limit;
        }

        @Override
        public int compareTo(Bridge other) {
            return other.limit - this.limit;
        }
    }

    static int findParent(int island) {
        if (parent[island] == island) return island;
        return parent[island] = findParent(parent[island]);
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
        int N = Integer.parseInt(st.nextToken()); // 섬의 개수 N 입력
        int M = Integer.parseInt(st.nextToken()); // 다리의 개수 M 입력

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        ArrayList<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 섬 번호 A 입력
            int B = Integer.parseInt(st.nextToken()); // 섬 번호 B 입력
            int C = Integer.parseInt(st.nextToken()); // 중량제한 C 입력
            bridges.add(new Bridge(A, B, C));
        }

        // 공장이 위치한 섬의 번호 입력
        st = new StringTokenizer(br.readLine());
        int factoryA = Integer.parseInt(st.nextToken());
        int factoryB = Integer.parseInt(st.nextToken());

        Collections.sort(bridges);

        for (int i = 0; i < M; i++) {
            int a = bridges.get(i).islandA;
            int b = bridges.get(i).islandB;
            int limit = bridges.get(i).limit;

            if (findParent(a) != findParent(b)) union(a, b);

            if (findParent(factoryA) == findParent(factoryB)) {
                // 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값 출력
                System.out.println(limit);
                return;
            }
        }
    }
}