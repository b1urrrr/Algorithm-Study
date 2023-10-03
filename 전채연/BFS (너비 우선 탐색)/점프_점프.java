/*
    백준 11060번 : 점프 점프
    - 문제 유형 : 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 너비 우선 탐색
*/

import java.io.*;
import java.util.*;

public class 점프_점프 {
    static int N;
    static int[] miro;

    private static int bfs() {
        int[] graph = new int[N];
        graph[0] = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);

        while (!que.isEmpty()) {
            int num = que.remove();

            for (int i = 1; i <= miro[num]; i++) {
                int nx = num + i;

                // 미로 크기를 벗어난 경우
                if (nx >= N) break;
                // 이미 방문한 칸인 경우
                if (graph[nx] > 0) continue;

                graph[nx] = graph[num] + 1;
                que.add(nx);
            }
        }

        return graph[N - 1] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 미로의 크기 N 입력
        miro = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            miro[i] = Integer.parseInt(st.nextToken()); // i번째 칸의 정수 입력
        }

        // 재환이가 최소 몇 번 점프를 해야 가장 오른쪽 끝 칸으로 갈 수 있는지 출력
        System.out.println(bfs());
    }
}
