// chap13 Q15. 특정 거리의 도시 찾기
// 또 틀림...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n13_15_re {
    static int n, m, k, x;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시 개수
        m = Integer.parseInt(st.nextToken()); // 도로 개수
        k = Integer.parseInt(st.nextToken()); // 최단 거리 정보
        x = Integer.parseInt(st.nextToken()); // 출발도시 번호

        distance = new int[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
            distance[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
        }

        // 출발 도시까지의 거리는 0으로 설정
        distance[x] = 0;

        // BFS 수행
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (int i = 0; i < graph.get(nowNode).size(); i++) {
                int nextNode = graph.get(nowNode).get(i);

                // 아직 방문하지 않은 도시라면
                if (distance[nextNode] == -1) {
                    // 최단 거리 갱신
                    distance[nextNode] = distance[nowNode] + 1;
                    queue.offer(nextNode);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                result.add(i);
            }
        }

        if (result.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(result);
        for (int node : result) {
            System.out.println(node);
        }
    }
}