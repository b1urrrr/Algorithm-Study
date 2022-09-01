import java.io.*;
import java.util.*;

public class Practice10_9 {
    static int N; // 강의의 수 N, 최소시간 count
    static int[] indegree, time; // 노드의 전입차수, 강의를 수강하기까지 걸리는 시간
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>(); // 간선 리스트

    static void topologySort() {
        Queue<Integer> que = new LinkedList<>();
        int[] result = new int[N + 1];

        // 전입차수가 0인 시작 노드 큐에 삽입 및 결과 초기화
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) que.add(i);
            result[i] = time[i];
        }

        while (!que.isEmpty()) {
            int node = que.remove();

            // 큐에서 반환된 노드와 연결된 간선 제거
            for (int i = 0; i < edges.get(node).size(); i++) {
                // 현재 노드의 커리큘럼이 수강 시간 최대값이면 대입
                result[edges.get(node).get(i)] = Math.max(result[edges.get(node).get(i)], result[node] + time[edges.get(node).get(i)]);
                indegree[edges.get(node).get(i)]--;
                // 전입차수가 0이 되었으면 큐에 삽입
                if (indegree[edges.get(node).get(i)] == 0) que.add(edges.get(node).get(i));
            }
        }

        // 모든 강의들의 수강하기까지 걸리는 최소 시간 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 강의의 수 N 입력
        indegree = new int[N + 1];
        time = new int[N + 1];

        // 간선 리스트 초기화
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        // 강의 정보 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken()); // 강의 시간 입력
            
            while (true) {
                // 먼저 들어야하는 강의들의 번호 입력
                int lecture = Integer.parseInt(st.nextToken());

                // -1이 입력되면 반복문 종료
                if (lecture == -1) break;

                edges.get(lecture).add(i);
                indegree[i]++;
            }
        }

        // 위상 정렬 실행
        topologySort();
    }
}
