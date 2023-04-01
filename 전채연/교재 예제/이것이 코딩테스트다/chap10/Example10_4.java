package chap10;

import java.io.*;
import java.util.*;

public class Example10_4 {
    // 노드의 개수 v와 간선의 개수 e
    static int v, e;
    // 부모 테이블
    static int[] parent;

    // 루트 노드 탐색 (특정 원소가 속한 집합 찾기)
    static int findParent(int node) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
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

        // 사이클 발생 여부 변수
        boolean cycle = false;

        // Union 수행
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 사이클이 발생한 경우 종료
            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            }
            // 사이클이 발생하지 않았으면 Union 수행
            else unionParent(a, b);
        }

        // 결과 출력 
        if (cycle) System.out.println("사이클이 발생했습니다.");
        else System.out.println("사이클이 발생하지 않았습니다.");
    }
}
