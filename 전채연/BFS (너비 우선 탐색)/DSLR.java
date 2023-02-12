/*
    백준 9019번 : DSLR
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : BFS (너비 우선 탐색)
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class DSLR {
    static char[] dx = {'D', 'S', 'L', 'R'};

    // DSLR 연산 결과를 반환한느 메서드
    static int dslr(char type, int num) {
        switch(type) {
            // D 연산
            case 'D':
                return num * 2 % 10000;
            // S 연산
            case 'S':
                if (num == 0) return 9999;
                return num - 1;
            // L 연산
            case 'L':
                int l = num % 1000 * 10;
                l += num / 1000;
                return l;
            // R 연산
            case 'R':
                int r = num % 10 * 1000;
                r += num / 10;
                return r;
            default:
                return -1;
        }
    }

    // 너비 우선 탐색 메서드
    static String bfs(int a, int b) {
        String[] graph = new String[10000];
        Queue<Integer> que = new LinkedList<>();
        que.add(a);
        graph[a] = "";

        while (!que.isEmpty()) {
            int node = que.remove();
            for (int i = 0; i < 4; i++) {
                int next = dslr(dx[i], node);
                // 이미 방문한 노드인 경우
                if (graph[next] != null) continue;
                que.add(next);
                graph[next] = graph[node] + dx[i];
                if (next == b) return graph[next];
            }
        }
        return "fail";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력
        for (int i = 0; i < T; i++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 레지스터 초기 값 A 입력
            int B = Integer.parseInt(st.nextToken()); // 레지스터 최종 값 B 입력
            System.out.println(bfs(A, B)); // A에서 B로 변환하기 위한 최소한의 명령어 나열 출력
        }
    }
}
