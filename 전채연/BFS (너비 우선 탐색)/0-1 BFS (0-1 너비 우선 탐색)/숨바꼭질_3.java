/*
    백준 13549번 : 숨바꼭질 3
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 데이크스트라, 0-1 너비 우선 탐색
    - 풀이 유형 : 0-1 BFS (0-1 너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 숨바꼭질_3 {
    static final int MAX = 200000;
    static int k;
    static int[] graph;

    static int bfs(int start) {
        graph[start] = 0;
        Deque<Integer> dq = new LinkedList<>();
        dq.add(start);
        
        while (!dq.isEmpty()) {
            int x = dq.remove();
            if (x == k) break;

            // 순간이동을 한 경우
            if (2 * x <= MAX && graph[2 * x] == -1) {
                graph[2 * x] = graph[x];
                dq.addFirst(2 * x);
            }
            // 뒤로 걷는 경우
            if (x - 1 >= 0 && graph[x - 1] == -1) {
                graph[x - 1] = graph[x] + 1;
                dq.addLast(x - 1);
            }
            // 앞으로 걷는 경우
            if (x + 1 <= MAX && graph[x + 1] == -1) {
                graph[x + 1] = graph[x] + 1; 
                dq.addLast(x + 1);
            }
        }

        return graph[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이의 위치 (0 ~ 100,000)
        k = Integer.parseInt(st.nextToken()); // 동생의 위치 (0 ~ 100,000)
        graph = new int[MAX + 1];
        Arrays.fill(graph, -1);

        System.out.println(bfs(n));
    }
}
