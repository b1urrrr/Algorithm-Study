/*
 * @author Minyeong Park
 * @date 2023.03.27.
 * 이진 검색 트리
 * 모르겠어서.. 원리 및 코드 참고 : https://girawhale.tistory.com/59
 * 문제 링크 : https://www.acmicpc.net/problem/5639
 */


import java.io.*;

class Node {
    int num;
    Node left, right;

    public Node(int num) {
        this.num = num;
    }

    public Node(int num, Node left, Node right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

    void insert(int n) {
        if (n < this.num) {
            if (this.left == null)
                this.left = new Node(n);
            else
                this.left.insert(n); // 제일 왼쪽 마지막으로 가서 빈 자리에 추가함
        } else {
            if (this.right == null)
                this.right = new Node(n);
            else
                this.right.insert(n); // 제일 오른쪽 마지막으로 가서 빈 자리에 추가함
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    // 후위 순회
    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);          // 왼쪽 자식 노드 탐색 (재귀함수로 돌면서 결국 이 왼쪽 자식을 먼저 방문한 게 되고 왼쪽 자식이 먼저 출력됨)
        postOrder(node.right);         // 오른쪽 자식 노드 탐색
        System.out.println(node.num); // 다 탐색했으니까 현재 노드(부모) 출력
    }
}