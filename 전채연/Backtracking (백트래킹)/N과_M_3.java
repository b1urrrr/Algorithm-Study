/*
    백준 15651번 : N과 M (3)
    - 문제 유형 : 백트래킹
*/

import java.io.*;
import java.util.StringTokenizer;

public class N과_M_3 {
    static int N, M;
    static int[] sequence;  // 수열
    static StringBuilder sb = new StringBuilder();

    // 깊이 우선 탐색 메서드
    static void dfs(int depth){
        // M개의 수로 구성된 수열을 완성한 경우
        if (depth == M) {
            // 수열 출력
            for (int i = 0; i < M; i++) sb.append(sequence[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            sequence[depth] = i;
            dfs(depth + 1);
        }
        // 조건에 만족하는 수가 없다면 백트래킹
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken()); // 자연수의 최대값 N 입력
        M = Integer.parseInt(st.nextToken()); // 수열의 길이 M 입력
        sequence = new int[M];

        dfs(0); // 깊이 우선 탐색 시작

        System.out.println(sb);
    }
}