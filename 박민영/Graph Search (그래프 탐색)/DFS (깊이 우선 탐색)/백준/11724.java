/*
 * @author Minyeong Park
 * @date 2023.03.16.
 * 연결 요소의 개수
 * 문제 링크 : https://www.acmicpc.net/problem/11724
 */



import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cnt++; // 새로 연결되는 부분
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int start) {
        if (visited[start]) {
            return;
        }

        // 방문 안 한 노드에 대해
        visited[start] = true; // 이제 방문하므로 true로 미리 설정정
        for (int i : list.get(start)) {
            if (!visited[i])
                dfs(i);
        }
    }
}