package chap05;

import java.util.ArrayList;

public class Example5_7 {
    static class Node {
        private int index;
        private int distance;
    
        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    
        void show() {
            System.out.printf("(%d, %d)\n", this.index, this.distance);
        }
    }

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 노드 0 초기화
        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        // 노드 1 초기화
        graph.get(1).add(new Node(0, 7));

        // 노드 2 초기화
        graph.get(2).add(new Node(0, 5));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
        }
    }
}
