/*
 * @author Minyeong Park
 * @date 2023.03.29.
 * LCA
 * 문제 링크 : https://www.acmicpc.net/problem/11437
 */


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> list;
    static int[] depth, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 트리 생성
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }



        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        // 깊이와 부모 찾기
        depth = new int[n + 1];
        parent = new int[n + 1];
        dfs(1, 1);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(solve(a, b) + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node, int cnt) { // node : 방문한 노드, cnt : 현재 깊이
        depth[node] = cnt;

        for (int child : list.get(node)) { // node와 연결된 노드들 파악
            if (depth[child] == 0) { // 깊이 계산이 안 된 곳은 자식 노드임
                dfs(child, cnt + 1);
                parent[child] = node;
            }
        }
    }

    static int solve(int a, int b) {
        // 같은 층으로 만들기
        while (depth[a] > depth[b]) { // a가 더 밑에 있는 경우이므로 a를 위로 올려야 함
            a = parent[a]; // 부모로 올려서 a를 위(부모 자리)로 올림
        }
        while (depth[a] < depth[b]) { // b가 더 밑에 있는 경우이므로 b를 위로 올려야 함
            b = parent[b]; // 부모로 올려서 b를 위(부모 자리)로 올림
        }

        // 같은 층인데 같지 않다면 (부모가 다른 경우)
        while (a != b) { // 같은 부모를 찾을 때까지 반복
            a = parent[a];
            b = parent[b];
        }

        return a; // 여기 단계에서는 a와 b의 공통 부모를 찾은 경우니까 a만 리턴해도 됨
    }
}