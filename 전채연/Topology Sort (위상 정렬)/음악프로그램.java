/*
    백준 2623번 : 음악프로그램
    - 문제 유형 : 그래프 이론, 위상 정렬
*/

import java.io.*;
import java.util.*;

public class 음악프로그램 {
    static int N, M;
    static int[] indegree;
    static List<List<Integer>> edges = new ArrayList<>();

    /** 가수들에 대해 위상 정렬 수행 */
    static void topologySort() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> result = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {
            int singer = que.remove();
            result.add(singer);
            for (int i = 0; i < edges.get(singer).size(); i++) {
                int next = edges.get(singer).get(i);
                if (--indegree[next] == 0) que.add(next);
            }
        }

        // 남일이가 순서를 정하는 것이 불가능할 경우 (사이클 발생)
        if (result.size() < N) {
            System.out.println(0);
            return;
        }

        // 남일이가 정한 가수들의 출연 순서 입력
        for (int i = 0; i < result.size(); i++) bw.write(result.get(i) + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가수의 수 N 입력
        M = Integer.parseInt(st.nextToken()); // 보조 PD의 수 M 입력
        indegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken()); // 보조 PD가 담당한 가수의 수 입력

            int previous;
            int next = Integer.parseInt(st.nextToken());
            for (int j = 1; j < count; j++) {
                previous = next; // 먼저 출연하는 가수 번호 입력
                next = Integer.parseInt(st.nextToken()); // 다음에 출연하는 가수 번호 입력
                edges.get(previous).add(next);
                indegree[next]++;
            }
        }

        // 위상 정렬 수행
        topologySort();
    }
}
