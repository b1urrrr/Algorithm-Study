package chap10;

public class Example10_2 {
    static int[] parent = new int[(int) 1e9];

    static int findParent(int node) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }
}
