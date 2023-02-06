/*
 * @author Minyeong Park
 * @date 2023.02.04.
 * 상근이의 여행
 * (BFS로 풀어보려 했으나 중간에 막혀서 다른 분 코드 참고해서 보완함)
 * 참고 : https://codingtalk.tistory.com/232
 * 문제 링크 : https://www.acmicpc.net/problem/9372
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = 0;

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                list.add(new ArrayList<Integer>());
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            boolean[] visited = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            q.offer(1);
            visited[1] = true;
            while (!q.isEmpty()) {
                answer++;
                int node = q.poll();
                for (int j = 0; j < list.get(node).size(); j++) {
                    int next = list.get(node).get(j);
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }

            System.out.println(answer - 1);
        }
    }
}