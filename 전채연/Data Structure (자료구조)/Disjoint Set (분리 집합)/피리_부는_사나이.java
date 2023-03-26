/*
    백준 16724번 : 피리 부는 사나이
    - 문제 유형 : 자료구조, 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 분리 집합
    - 풀이 유형 : 분리 집합
*/

import java.io.*;
import java.util.*;

public class 피리_부는_사나이 {
    static int N, M;
    static Node[][] parent;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node other) {
            int a = this.x * M + this.y;
            int b = other.x * M + other.y;
            return a - b;
        }
    }

    /** 방향 문자를 입력 받아 방향 인덱스 값 반환 */
    static int getDirectionIndex(char dir) {
        switch(dir) {
            case 'U': return 0; // 위로 이동
            case 'D': return 1; // 아래로 이동
            case 'L': return 2; // 왼쪽으로 이동
            case 'R': return 3; // 오른쪽으로 이동
        }
        return -1;
    }

    /** 루트 노드 반환 */
    static Node findParent(Node node) {
        if (node == parent[node.x][node.y]) return node;
        return parent[node.x][node.y] = findParent(parent[node.x][node.y]);
    }

    /** 합집합 연산 수행 */
    static void union(Node node, int dir) {
        // 이동한 노드 구하기
        int nx = node.x + dx[dir];
        int ny = node.y + dy[dir];

        // 지도의 범위를 벗어난 경우 (나중에 생략할 것)
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
        Node next = new Node(nx, ny);

        Node a = findParent(node);
        Node b = findParent(next);
        if (a.compareTo(b) > 0) parent[a.x][a.y] = b;
        else parent[b.x][b.y] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 지도의 행의 수 N 입력
        M = Integer.parseInt(st.nextToken()); // 지도의 열의 수 M 입력
        parent = new Node[N][M];
        
        // 부모 테이블 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                parent[i][j] = new Node(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char dir = s.charAt(j); // 지도의 정보 입력
                union(new Node(i, j), getDirectionIndex(dir));
            }
        }

        // ‘SAFE ZONE’의 최소 개수 출력
        HashSet<Node> nodeSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nodeSet.add(findParent(new Node(i, j)));
            }
        }
        System.out.println(nodeSet.size());
    }
}
