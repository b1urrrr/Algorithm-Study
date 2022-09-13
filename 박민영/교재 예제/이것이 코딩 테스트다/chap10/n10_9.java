// chap10 (4) 실전 문제 : 커리큘럼
// 원리가 잘 기억나지 않아서... 주석이랑 코드 보면서 다시 이해하면서 공부하면서 풀었다..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n10_9 {
    public static int n;
    // 모든 노드에 대한 진입 차수는 0으로 초기화
    public static int[] indegree = new int[501];
    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // 각 강의 시간을 0으로 초기화
    public static int[] times = new int[501];

    // 위상 정렬 함수
    public static void topologySort() {
        int[] result = new int[501]; // 알고리즘 수행 결과를 담을 배열
        for (int i = 1; i <= n; i++) {
            result[i] = times[i]; // 자기 자신의 강의 시간으로 초기화
        }

        Queue<Integer> q = new LinkedList<>(); // 큐 라이브러리 사용

        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 원소 꺼내기
            int now = q.poll();

            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int i = 0; i < graph.get(now).size(); i++) {
                // 인접한 노드에 대해 더 오랜 시간이 걸리는 경우의 시간 값을 저장
                result[graph.get(now).get(i)] = Math.max(
                        result[graph.get(now).get(i)], // 현재 result에 저장된 해당 노드의 시간
                        result[now] + times[graph.get(now).get(i)] // 해당 노드의 시간 + 인접한 노드의 시간
                );
                indegree[graph.get(now).get(i)] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        // 위상정렬을 수행한 결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 방향 그래프의 모든 간선 정보를 입력 받기
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            times[i] = x;

            // 해당 강의를 듣기 위해 먼저 들어야 하는 강의들의 번호 입력
            while (true) {
                x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                indegree[i] += 1;
                graph.get(x).add(i); // x가 가리키는(다른 곳으로 진입하는) 노드 리스트에 i를 추가
            }
        }

        topologySort();
    }
}
