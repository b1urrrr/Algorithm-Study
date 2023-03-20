/*
    백준 20040번 : 사이클 게임
    - 문제 유형 : 자료 구조, 분리 집합
*/

import java.io.*;
import java.util.*;

public class 사이클_게임 {
    static int[] parent;
    static boolean ended;

    /** 루트 노드 번호 반환 */
    static int findParent(int dot) {
        if (dot == parent[dot]) return dot;
        return parent[dot] = findParent(parent[dot]);
    }

    /** 합집합 연산 수행 */
    static void union(int dot1, int dot2) {
        int parent1 = findParent(dot1);
        int parent2 = findParent(dot2);
        
        // 사이클이 발견된 경우
        if (parent1 == parent2) ended = true;

        if (parent1 < parent2) parent[parent2] = parent1;
        else parent[parent1] = parent2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 점의 개수 n 입력
        int m = Integer.parseInt(st.nextToken()); // 진행된 차례의 수 m 입력
        
        // 부모 테이블 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int turn = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dot1 = Integer.parseInt(st.nextToken()); // 플레이어가 선택한 첫 번째 점의 번호 입력
            int dot2 = Integer.parseInt(st.nextToken()); // 플레이어가 선택한 두 번째 점의 번호 입력
            if (ended) continue;

            union(dot1, dot2);
            turn++;
        }

        // 처음으로 사이클이 만들어진 차례의 번호 출력
        if (ended) System.out.println(turn);
        // m 번의 차례를 모두 처리한 이후에도 종료되지 않았다면 0 출력
        else System.out.println(0);
    }
}
