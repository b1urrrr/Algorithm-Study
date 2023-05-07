/*
    백준 5014번 : 스타트링크
    - 문제 유형 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
*/

import java.io.*;
import java.util.*;

public class 스타트링크 {
    static int[] floors, move = new int[2];
    static int F, S, G, U, D;

    static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        floors[S] = 1;
        que.add(S);

        while (!que.isEmpty()) {
            int next = que.remove();
            if (next == G) return floors[next] - 1;

            for (int i = 0; i < 2; i++) {
            int floor = next + move[i];

            // 건물의 층에서 벗어난 경우
            if (floor < 1 || floor > F) continue;
            // 이미 방문한 층인 경우
            if (floors[floor] > 0) continue;

            floors[floor] = floors[next] + 1;
            que.add(floor);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 총 층수 F 입력
        S = Integer.parseInt(st.nextToken()); // 강호가 있는 층 S 입력
        G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 층 G 입력
        U = Integer.parseInt(st.nextToken()); // U버튼이 올라가는 층수 U 입력
        D = Integer.parseInt(st.nextToken()); // D버튼이 내려가는 층수 D 입력
        floors = new int[F + 1];
        move[0] = U;
        move[1] = -D;

        int result = bfs();
        if (result == -1) System.out.println("use the stairs");
        else System.out.println(result);
    }
}
