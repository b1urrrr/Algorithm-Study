package chap10;

import java.io.*;
import java.util.*;

public class Example10_1 {
    // 노드의 개수 v와 간선의 개수 e
    static int v, e;
    // 부모 테이블
    static int[] parent;

    // 루트 노드 탐색 (특정 원소가 속한 집합 찾기)
    static int findParent(int node) {
        if (node == parent[node]) return node;
        return findParent(parent[node]);
    }

    // Union 함수
    static void unionParent(int a, int b) {
        // 각각의 루트 노드 탐색
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); // 노드의 개수 v 입력 
        e = Integer.parseInt(st.nextToken()); // 간선의 개수 e 입력
        parent = new int[v + 1];

        // 부모 테이블 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // Union 연산 수행
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unionParent(a, b);
        }

        // 각 원소가 속한 집합 출력
        System.out.print("각 원소가 속한 집합 : ");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블 : ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
