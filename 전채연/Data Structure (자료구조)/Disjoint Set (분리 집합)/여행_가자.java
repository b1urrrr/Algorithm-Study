/*
    백준 1976번 : 여행 가자
    - 문제 유형 : 자료구조, 분리 집합, 그래프 이론
*/

import java.io.*;
import java.util.*;

public class 여행_가자 {
    static int N; // 도시의 수 N
    static int[] parent; // 부모 노드 배열
    
    // 부모 노드 탐색 함수
    static int find(int a) {
        if (parent[a] == a) return a;
        // 경로 압축 기법 사용
        return parent[a] = find(parent[a]);
    }

    // 합집합 함수
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시의 수 N 입력
        int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시의 수 M 입력
        parent = new int[N + 1];

        // 모든 요소의 부모 노드를 자기 자신으로 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 도시의 연결 정보 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    union(i, j); // 부분 집합 합치기
            }
        }

        // 여행 계획 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = find(Integer.parseInt(st.nextToken())); // 첫 번째 여행지 입력
        for (int i = 1; i < M; i++) {
            // 서로 연결되지 않았다면 NO 출력 후 종료
            if (first != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
