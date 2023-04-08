/*
    백준 1766번 : 문제집
    - 문제 유형 : 자료구조, 그래프 이론, 우선순위 큐, 위상 정렬
*/

import java.io.*;
import java.util.*;

public class 문제집 {
    static int N, M;
    static int[] indegree;
    static List<List<Integer>> edges = new ArrayList<>();

    /** 문제들에 대해 위상정렬 수행 */
    static void topologySort() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) pq.add(i);
        }

        while (!pq.isEmpty()) {
            int problem = pq.remove();
            result.add(problem);
            for (int i = 0; i < edges.get(problem).size(); i++) {
                int next = edges.get(problem).get(i);
                if (--indegree[next] == 0) pq.add(next);
            }
        }

        // 민오가 풀어야 하는 문제 번호 순서대로 출력
        for (int i = 0; i < result.size(); i++) bw.write(result.get(i) + " ");
        bw.write("\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 문제의 수 N 입력
        M = Integer.parseInt(st.nextToken()); // 먼저 푸는 것이 좋은 문제에 대한 정보의 개수 M 입력
        indegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 먼저 푸는 것이 좋은 문제 A 번호 입력
            int B = Integer.parseInt(st.nextToken()); // A를 풀고 난 뒤에 푸는 것이 좋은 문제 B 번호 입력
            edges.get(A).add(B);
            indegree[B]++;
        }

        // 위상 정렬 수행
        topologySort();
    }
}
