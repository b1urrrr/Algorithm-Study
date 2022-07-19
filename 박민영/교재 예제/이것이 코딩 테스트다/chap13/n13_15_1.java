// chap13 Q.15 특정 거리의 도시 찾기
// BFS로 풀어봤으나 막혀서 해설 보면서 보완함..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n13_1_1 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        distance = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
            distance[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        // 출발 도시까지의 거리는 0으로 설정
        distance[x] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                if (distance[next] == -1) {
                    distance[next] = distance[node] + 1;
                    queue.offer(next);
                }
            }
        }

        boolean is_printed = false;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                is_printed = true;
                continue;
            }
            if (i == distance.length - 1 && !is_printed) {
                System.out.println(-1);
            }
        }
    }
}
