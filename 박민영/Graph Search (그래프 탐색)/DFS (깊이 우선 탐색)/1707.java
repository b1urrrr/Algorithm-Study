/*
 * @author Minyeong Park
 * @date 2023.03.23.
 * 이분 그래프
 * 원리 및 코드 참고 : https://www.youtube.com/watch?v=mDSQfb5Rqc4
 * 문제 링크 : https://www.acmicpc.net/problem/1707
 */



import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] a;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            a = new ArrayList[v + 1];
            visited = new boolean[v + 1];
            check = new int[v + 1];
            IsEven = true;
            for (int i = 1; i <= v; i++) {
                a[i] = new ArrayList<Integer>();
            }


            // 에지 데이터 저장하기
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                a[start].add(end);
                a[end].add(start);
            }

            // 모든 노드에서 dfs 실행해야 함
            for (int i = 1; i <= v; i++) {
                if (IsEven) {
                    dfs(i);
                } else {
                    break;
                }
            }

            if (IsEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (int i : a[start]) { // 인접리스트로 받아서 start에서 연결된 모든 노드를 탐색하게 됨.
            if(!visited[i]) {
                // 바로 직접에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요.
                check[i] = (check[start] + 1) % 2; // 2개의 집합으로 나눔
                dfs(i);
            } else if (check[start] == check[i]) {
                IsEven = false;
            }
        }
    }
}