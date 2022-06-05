package chap05;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Example5_9 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited = new boolean[9];

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int v = que.remove();
            System.out.print(v + " ");
            
            for (int i = 0; i < graph.get(v).size(); i++) {
                if (!visited[graph.get(v).get(i)]) {
                    que.add(graph.get(v).get(i));
                    visited[graph.get(v).get(i)] = true;
                }
            }
        }
    } 

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1 초기화
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2 초기화
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3 초기화
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4 초기화
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5 초기화
        graph.get(5).add(3);
        graph.get(5).add(5);

        // 노드 6 초기화
        graph.get(6).add(7);

        // 노드 7 초기화
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8 초기화
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }
}
