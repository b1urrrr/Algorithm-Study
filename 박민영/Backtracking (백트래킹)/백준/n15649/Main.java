/*
 * @author Minyeong Park
 * @date 2022.04.23.
 * N과 M (1)
 * 참고 : https://st-lab.tistory.com/114
 *       https://www.youtube.com/watch?v=Enz2csssTCs
 * 문제 링크 : https://www.acmicpc.net/problem/15649
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit; // 1 ~ N까지의 각 수를 방문했는지 여부
    static int[] arr;       // 이번에 출력할 수열을 담는 배열

    public static void dfs(int N, int M, int depth) {
        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            // 만약 해당 노드(값)을 방문하지 않았다면?
            if (visit[i] == false) {
                visit[i] = true;    // 해당 노드를 방문 상태로 변경
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i+1값 저장
                dfs(N, M, depth + 1); // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];
        dfs(N, M, 0);
    }
}