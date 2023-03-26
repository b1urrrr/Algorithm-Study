package chap10;

import java.io.*;
import java.util.*;

public class Practice10_7 {
    static int N, M; // 학생의 수 N, 연산의 개수 M
    static int[] parent; // 부모 테이블

    // 루트 노드 탐색 함수
    static int parent(int a) {
        if (a == parent[a]) return a;
        // 경로 압축 기법 사용
        return parent[a] = parent(parent[a]);
    }

    // 팀 합치기 연산 함수
    static void union(int a, int b) {
        a = parent(a);
        b = parent(b);
        if (a < b) parent[a] = b;
        else parent[b] = a;
    }

    // 같은 팀 여부 확인 연산 함수
    static void find(int a, int b) {
        if (parent(a) == parent(b)) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생의 수 입력
        M = Integer.parseInt(st.nextToken()); // 연산의 수 입력
        parent = new int[N + 1];

        // 부모 테이블 자기 자신으로 초기화
        for (int i = 0; i <= N; i++) parent[i] = i;

        // 연산 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken()); // 연산 유형 입력
            int a = Integer.parseInt(st.nextToken()); // 학생 팀1 입력
            int b = Integer.parseInt(st.nextToken()); // 학생 팀2 입력

            switch(type) {
                case 0: // 팀 합치기 연산
                    union(a, b);                    
                    break;
                case 1: // 같은 팀 여부 확인 연산
                    find(a, b);
                    break;
                default:
            }
        }
    }
}
