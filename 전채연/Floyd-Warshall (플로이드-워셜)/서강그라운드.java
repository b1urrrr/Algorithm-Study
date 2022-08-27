/*
    백준 14938번 : 서강그라운드
    - 문제 유형 : 플로이드-워셜
*/

import java.io.*;
import java.util.*;

public class 서강그라운드 {
    static final int INF = (int) 1e9;
    static int[][] spt; // 최단 거리 테이블 (shortest path table)

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) return -1;
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 지역의 개수 n 입력
        int m = Integer.parseInt(st.nextToken()); // 예은이의 수색 범위 m 입력
        int r = Integer.parseInt(st.nextToken()); // 길의 개수 r 입력
        spt = new int[n + 1][n + 1];

        // 각 구역의 아이템의 수 입력
        st = new StringTokenizer(br.readLine());
        int[] item = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken()); // 아이템 수 t 입력
        }

        // 최단 거리 테이블 무한으로 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(spt[i], INF);
        }

        // 시작 노드와 도착 노드가 동일하면 최단 거리 테이블 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) spt[i][j] = 0;
            }
        }

        // 길의 정보 입력
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 길 양 끝의 지역 a 입력
            int b = Integer.parseInt(st.nextToken()); // 길 양 끝의 지역 b 입력
            int l = Integer.parseInt(st.nextToken()); // 길의 길이 l 입력
            spt[a][b] = l;
            spt[b][a] = l;
        }

        // 플로이드 워셜 알고리즘 실행
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    spt[a][b] = Math.min(spt[a][b], spt[a][i] + spt[i][b]);
                }
            }
        }

        // 최대 아이템 개수 계산
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0; // i번 지역에 떨어졌을 때 얻을 수 있는 아이템 최대 개수
            for (int j = 1; j <= n; j++) {
                // 수색 범위보다 가까운 지역이면 아이템 개수 더함
                if (spt[i][j] <= m) count += item[j];
            }
            max = Math.max(max, count);
        }

        // 예은이가 얻을 수 있는 최대 아이템 개수 출력
        System.out.println(max);
    }
}
