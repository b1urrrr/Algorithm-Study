/*
    백준 1697번 : 숨바꼭질
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

public class 숨바꼭질 {
    static final int MAX = 100000;
    static int k;
    static int[] graph;
    static int min = Integer.MAX_VALUE;

    static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        
        while (!que.isEmpty()) {
            int x = que.remove();

            // 순간이동을 한 경우
            if (2 * x <= MAX && graph[2 * x] == 0) {
                graph[2 * x] = graph[x] + 1;
                que.add(2 * x);
            }
            // 뒤로 걷는 경우
            if (x - 1 >= 0 && graph[x - 1] == 0) {
                graph[x - 1] = graph[x] + 1;
                que.add(x - 1);
            }
            // 앞으로 걷는 경우
            if (x + 1 <= MAX && graph[x + 1] == 0) {
                graph[x + 1] = graph[x] + 1; 
                que.add(x + 1);
            }

            if (graph[k] > 0) break;
        }

        return graph[k] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이의 위치 (0 ~ 100,000)
        k = Integer.parseInt(st.nextToken()); // 동생의 위치 (0 ~ 100,000)
        graph = new int[MAX + 1];

        graph[n] = 1;
        System.out.println(bfs(n));
    }
}
