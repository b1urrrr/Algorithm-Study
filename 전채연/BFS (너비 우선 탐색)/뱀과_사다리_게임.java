/*
    백준 16928번 : 뱀과 사다리 게임
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 뱀과_사다리_게임 {
    static int[] move = new int[101]; // 사다리와 뱀 배열
    static int[] graph = new int[101]; // 보드판 배열
    static int[] dx = {1, 2, 3, 4, 5, 6}; // 주사위 배열

    // 너비 우선 탐색 메서드
    static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        // 시작 노드 큐 추가 후 방문 처리
        que.add(1);
        graph[1] = 1;

        while (!que.isEmpty()) {
            int n = que.remove();

            for (int i = 0; i < 6; i++) {
                int nx = n + dx[i];
                // 100번 칸을 넘어간 경우
                if (nx > 100) continue;
                // 사다리나 뱀이 있는 경우 이동
                if (move[nx] > 0) nx = move[nx];
                // 이미 방문한 노드인 경우
                if (graph[nx] > 0) continue;

                que.add(nx);
                graph[nx] = graph[n] + 1; // 방문 처리
            }
        }

        return graph[100] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리의 수
        int m = Integer.parseInt(st.nextToken()); // 뱀의 수

        // 사다리 기록
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        // 뱀 기록
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken()); 
        }

        // 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값 출력
        System.out.println(bfs());
    }
}
