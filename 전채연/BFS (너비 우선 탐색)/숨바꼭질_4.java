/*
    백준 13913번 : 숨바꼭질 4
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.*;

public class 숨바꼭질_4 {
    static final int MAX = 200000;
    static int k;
    static int[] graph;
    static int[] path;
    static int min = Integer.MAX_VALUE;

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        graph[start] = 1;
        que.add(start);
        
        while (!que.isEmpty()) {
            int x = que.remove();
            if (x == k) break;

            // 순간이동을 한 경우
            if (2 * x <= MAX && graph[2 * x] == 0) {
                graph[2 * x] = graph[x] + 1;
                path[2 * x] = x;
                que.add(2 * x);
            }
            // 뒤로 걷는 경우
            if (x - 1 >= 0 && graph[x - 1] == 0) {
                graph[x - 1] = graph[x] + 1;
                path[x - 1] = x;
                que.add(x - 1);
            }
            // 앞으로 걷는 경우
            if (x + 1 <= MAX && graph[x + 1] == 0) {
                graph[x + 1] = graph[x] + 1;
                path[x + 1] = x;
                que.add(x + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이의 위치 (0 ~ 100,000)
        k = Integer.parseInt(st.nextToken()); // 동생의 위치 (0 ~ 100,000)
        graph = new int[MAX + 1];
        path = new int[MAX + 1];

        bfs(n);

        System.out.println(graph[k] - 1);

        StringBuilder sb = new StringBuilder();
        sb.append(k);
        while (n != k) {
            k = path[k];
            sb.insert(0, k + " ");
        }

        // 이동 경로 출력
        System.out.println(sb);
    }
}
