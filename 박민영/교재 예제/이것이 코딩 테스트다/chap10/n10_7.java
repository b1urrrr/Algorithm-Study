// chap10 (2) 실전 문제 : 팀 결성
// 원리가 잘 기억나지 않아서 해설 주석 보면서 구현함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n10_7 {
    static int n, m;
    static int v, e;
    static int[] parent = new int[100001];

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a > b) {
            parent[a] = b; // 더 번호가 작은 원소가 부모 노드가 되도록 설정
        } else {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Union 연산을 각각 수행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int menu = Integer.parseInt(st.nextToken());
            switch (menu) {
                case 0 :
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    unionParent(a,b);
                    break;
                case 1 :
                    int a2 = Integer.parseInt(st.nextToken());
                    int b2 = Integer.parseInt(st.nextToken());
                    if (findParent(a2) == findParent(b2)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
            }
        }
    }
}
