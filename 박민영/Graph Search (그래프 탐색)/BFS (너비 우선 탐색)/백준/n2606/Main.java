/*
 * @author Minyeong Park
 * @date 2022.07.01.
 * 바이러스 (인접리스트로 풀었음)
 * 문제 링크 : https://www.acmicpc.net/problem/2606
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        nodes = new ArrayList[node+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        visited = new boolean[node+1];
        StringTokenizer st;
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }

        queue.offer(1);
        visited[1] = true;
        bfs();

        System.out.println(count);
    }
    static void bfs() {
        while (!queue.isEmpty()) {
            int cur_node = queue.poll();

            for (int next : nodes[cur_node]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
    }
}