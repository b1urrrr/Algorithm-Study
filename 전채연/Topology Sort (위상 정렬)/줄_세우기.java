/*
    백준 2252번 : 줄 세우기
    - 문제 유형 : 그래프 이론, 위상 정렬
*/

import java.io.*;
import java.util.*;

public class 줄_세우기 {
    static int N, M;
    static int[] indegree;
    static List<List<Integer>> edges = new ArrayList<>();

    /** 학생들을 대상으로 위상 정렬 수행 */
    public static void topologySort() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> result = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {
            int student = que.remove();
            result.add(student);

            for (int i = 0; i < edges.get(student).size(); i++) {
                int next = edges.get(student).get(i);
                if (--indegree[next] == 0) que.add(next);
            } 
        }

        // 학생들을 앞에서부터 줄을 세운 결과 출력
        for (int i = 0; i < result.size(); i++) bw.write(result.get(i) + " ");
        bw.write("\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생의 수 N 입력
        M = Integer.parseInt(st.nextToken()); // 키를 비교한 회수 M 입력
        indegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 앞에 서야하는 학생 A의 번호
            int B = Integer.parseInt(st.nextToken()); // 뒤에 서야하는 학생 B의 번호
            edges.get(A).add(B);
            indegree[B]++;
        }

        // 위상 정렬 수행
        topologySort();
    }
}
