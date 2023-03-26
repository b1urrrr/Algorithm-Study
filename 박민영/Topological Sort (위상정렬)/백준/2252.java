/*
 * @author Minyeong Park
 * @date 2023.03.25.
 * 줄 세우기
 * 문제 링크 : https://www.acmicpc.net/problem/2252
 */


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        int[] in_degree = new int[n + 1];
        in_degree[0] = -1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            in_degree[b]++; // 진입 차수 배열 데이터 저장 부분
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) { // 배열이 모두 0이 되거나 더 연결된 노드가 없을 때까지 반복
            int now = q.poll();
            sb.append(now + " ");
            for (int next : list[now]) {
                in_degree[next]--;
                if (in_degree[next] == 0) {
                    q.add(next);
                }
            }
            result.add(now);
        }

        System.out.println(sb);
    }
}