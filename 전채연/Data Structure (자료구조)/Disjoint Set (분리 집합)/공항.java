/*
    백준 10775번 : 공항
    - 문제 유형 : 자료구조, 그리디 알고리즘, 분리 집합
*/

import java.io.*;

public class 공항 {
    static int result = 0;
    static boolean closed;
    static int[] parent;

    /** 부모 노드 반환 */
    static int findParent(int plane) {
        if (parent[plane] == plane) return plane;
        return parent[plane] = findParent(parent[plane]);
    }

    /** 비행기 도킹 (합집합 연산) 후 도킹 가능 여부 반환 */
    static void union(int plane) {
        int a = findParent(plane);
        // 도킹이 불가능한 경우
        if (a == 0) {
            closed = true;
            return;
        }
        int b = findParent(a - 1);

        parent[a] = b;
        result++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine()); // 게이트의 수 G 입력
        int P = Integer.parseInt(br.readLine()); // 비행기의 수 P 입력

        // 부모 테이블 초기화
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine()); // 도킹 가능한 최소 번호 입력
            if (closed) continue;
            union(g);
        }

        // 승원이가 도킹시킬 수 있는 최대의 비행기 수 출력
        System.out.println(result);
    }
}
