/*
    백준 12851번 : 숨바꼭질 2
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 숨바꼭질2 {
    static final int MAX = 100000;
    static int[] graph = new int[MAX + 1];

    // 너비 우선 탐색 메서드
    static int bfs(int n, int k) {
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        que.add(n);
        graph[n]++;

        while (!que.isEmpty()) {
            int nx = que.remove();
            if (nx == k) count++; // 가장 빠른 시간으로 동생을 찾은 경우 count++

            // X - 1로 이동하는 경우
            if (nx - 1 >= 0 && (graph[nx - 1] == 0 || graph[nx - 1] == graph[nx] + 1)) {
                que.add(nx - 1);
                graph[nx - 1] = graph[nx] + 1;
            }
            // X + 1로 이동하는 경우
            if (nx + 1 <= MAX && (graph[nx + 1] == 0 || graph[nx + 1] == graph[nx] + 1)) {
                que.add(nx + 1);
                graph[nx + 1] = graph[nx] + 1;
            }
            // 2 * X로 순간이동하는 경우
            if (2 * nx <= MAX && (graph[2 * nx] == 0 || graph[2 * nx] == graph[nx] + 1)) {
                que.add(2 * nx);
                graph[2 * nx] = graph[nx] + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치 N 입력
        int K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치 K 입력

        int count = bfs(N, K); // 너비 우선 탐색
        System.out.println(graph[K] - 1); // 수빈이가 동생을 찾는 가장 빠른 시간 출력
        System.out.println(count); // 가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수 출력
    }    
}
