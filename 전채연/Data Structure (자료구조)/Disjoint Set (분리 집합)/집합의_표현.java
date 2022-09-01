/*
    백준 1717번 : 집합의 표현
    - 문제 유형 : 자료구조, 분리 집합
*/

import java.io.*;
import java.util.*;

public class 집합의_표현 {
    static int n, m; // 집합의 개수 0 ~ n, 연산의 개수 m
    static int[] parent; // 부모 테이블

    // 루트 노드 탐색 함수
    static int find(int a) {
        if (a == parent[a]) return a;
        // 경로 압축 기법 사용
        return parent[a] = find(parent[a]);
    }

    // 합집합 연산 함수
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 집합의 개수 n 입력
        m = Integer.parseInt(st.nextToken()); // 연산의 개수 m 입력
        parent = new int[n + 1];

        // 부모 테이블 자기 자신으로 초기화
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 연산의 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken()); // 연산 유형 입력
            int a = Integer.parseInt(st.nextToken()); // 피연산자1 입력
            int b = Integer.parseInt(st.nextToken()); // 피연산자2 입력

            switch (type) {
                case 0: // 합집합 연산인 경우
                    union(a, b);
                    break;
                case 1: // 같은 집합 포함 여부 연산인 경우
                    if (find(a) == find(b)) bw.write("YES\n");
                    else bw.write("NO\n");
                    break;
                default:
            }
        }

        bw.flush();
    }
}
