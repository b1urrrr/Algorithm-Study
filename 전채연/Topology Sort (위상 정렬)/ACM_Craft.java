/*
    백준 1005번 : ACM Craft
    - 문제 유형 : 그래프 이론, 다이나믹 프로그래밍, 위상 정렬
*/

import java.io.*;
import java.util.*;

public class ACM_Craft {
    static int N, K, W; // 건물의 개수 N, 건설순서 규칙의 개수 K, 승리하기 위해 건설해야하는 건물 W
    static int[] indegree, times; // 전입차수 배열, 건설시간 배열
    static ArrayList<ArrayList<Integer>> edges; // 간선 리스트

    static void topologySort() {
        Queue<Integer> que = new LinkedList<>();
        int[] result = new int[N + 1];

        // 전입차수가 0인 시작노드 처리 및 result 초기화
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) que.add(i);
            result[i] = times[i];
        }

        while (!que.isEmpty()) {
            int node = que.remove();

            // 큐에서 반환한 노드와 연결된 간선 제거
            for (int i = 0; i < edges.get(node).size(); i++) {
                // 더 오래걸리는 건설 시간으로 대입
                result[edges.get(node).get(i)] = Math.max(result[edges.get(node).get(i)], result[node] + times[edges.get(node).get(i)]);
                indegree[edges.get(node).get(i)]--;
                // 전입차수가 0이 되었다면 큐에 삽입
                if (indegree[edges.get(node).get(i)] == 0) que.add(edges.get(node).get(i));
            }
        }

        // 건물 W를 건설완료 하는데 드는 최소 시간 출력
        System.out.println(result[W]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 T 입력

        // 테스트 케이스 반복
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 건물의 개수 입력
            K = Integer.parseInt(st.nextToken()); // 건설순서 규칙의 개수 입력
            edges = new ArrayList<>();
            indegree = new int[N + 1];
            times = new int[N + 1];

            // 간선 리스트 초기화
            for (int i = 0; i <= N; i++) {
                edges.add(new ArrayList<>());
            }

            // 건설시간 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            // 건설순서 규칙 정보 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 건물1 입력
                int Y = Integer.parseInt(st.nextToken()); // 건물2 입력

                edges.get(X).add(Y);
                indegree[Y]++;
            }

            W = Integer.parseInt(br.readLine()); // 백준이가 승리하기 위해 건설해야 할 건물의 번호 입력

            // 위상 정렬 실행
            topologySort();
        }
    }
}
