import java.io.*;
import java.util.*;

public class Example10_6 {
    // 노드의 개수 v, 간선의 개수 e
    static int v, e;
    // 모든 노드에 대한 전입차수
    static int[] indegree;
    // 간선 리스트
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    static void topologySort() {
        // 위상 정렬 결과 리스트
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        // 전입차수가 0인 시작 노드 큐에 삽입
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) que.add(i);
        }

        // 큐가 비워질 때까지 반복
        while(!que.isEmpty()) {
            // 큐에서 노드 꺼내기
            int node = que.remove();
            result.add(node);

            // 해당 원소와 연결된 노드들의 집입차수 1 빼기
            for (int i = 0; i < edges.get(node).size(); i++) {
                indegree[edges.get(node).get(i)]--;
                // 전입차수가 0이면 큐에 삽입
                if (indegree[edges.get(node).get(i)] == 0) que.add(edges.get(node).get(i));
            }
        }

        // 위상 정렬 결과 출력
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); // 노드의 개수 입력
        e = Integer.parseInt(st.nextToken()); // 간선의 개수 입력
        indegree = new int[v + 1];

        // 간선 그래프 초기화
        for (int i = 0; i <= v; i++) {
            edges.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.get(a).add(b); // a -> b 연결
            indegree[b]++; // 전입차수 증가
        }

        topologySort();
    }
}
