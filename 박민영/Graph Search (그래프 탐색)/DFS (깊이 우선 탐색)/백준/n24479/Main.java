/*
 * @author Minyeong Park
 * @date 2022.06.11.
 * 알고리즘 수업 - 깊이 우선 탐색 1
 * 참고 및 코드 출처 : https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-24479-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%88%98%EC%97%85-%EA%B9%8A%EC%9D%B4-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89-1-boj-java
 * 문제 링크 : https://www.acmicpc.net/problem/24479
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[];
    static int n;
    static ArrayList<Integer>[] edges; // 인접리스트들을 담는 ArrayList
    static int[] answer; // 출력할 문자열을 담는 배열
    static int idx = 0;  // 출력할 때 순서대로 나올 수 있도록 인덱스를 저장하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점
        int m = Integer.parseInt(st.nextToken()); // 간선
        int r = Integer.parseInt(st.nextToken()); // 시작 정점


        visited = new boolean[n + 1];
        answer = new int[n + 1];

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        // 각 인접리스트 정렬
        for (int i = 1; i <= n; i++)
            Collections.sort(edges[i]);

        visited[r] = true;
        dfs(r); // 1번 정점

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int r) {
        answer[r] = ++idx;
        for (int next : edges[r]) {
            if (visited[next])
                continue;
            visited[next] = true;
            dfs(next);
        }
    }
}
