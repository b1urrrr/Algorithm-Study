import java.util.Comparator;

// 이진 검색트리
public class BinTree<K, V> {
    // 노드
    static class Node<K, V> {
        private K key;            // 키 값
        private V data;           // 데이터
        private Node<K, V> left;  // 왼쪽 자식 노드
        private Node<K, V> right; // 오른쪽 자식 노드

        // 생성자

        public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }
    }

    private Node<K,V> root; // 루트
    private Comparator<? super K> comparator = null; // 비교자

    // 생성자
    public BinTree() {
        root = null;
    }

    // 생성자
    public BinTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    // 두 키 값을 비교
    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
                : comparator.compare(key1, key2);
    }

    // 키에 의한 검색
    public V search(K key) {
        Node<K,V> p = root; // 루트에 주목

        while (true) {
            if (p == null) return null;         // 더 이상 진행하지 않으면 검색 실패
            int cond = comp(key, p.getKey());   // key와 노드 p의 키를 비교
            if (cond == 0) return p.getValue(); // 같으면 검색 성공
            else if (cond < 0)
                p = p.left;                     // key쪽이 작으면 왼쪽 서브 트리에서 검색
            else
                p = p.right;                    // key쪽이 크면 오른쪽 서브 트리에서 검색
        }
    }

    // node를 루트로 하는 서브 트리에 노드 <K,V>를 삽입
    private void addNode(Node<K,V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0) return; // key가 이진검색트리에 이미 있음
        else if (cond < 0) {
            if (node.left == null)
                node.left = new Node<K,V>(key, data, null, null);
            else
                addNode(node.left, key, data); // 왼쪽 서브 트리에 주목
        } else {
            if (node.right == null)
                node.right = new Node<K,V>(key, data, null, null);
            else
                addNode(node.right, key, data); // 오른쪽 서브 트리에 주목
        }
    }

    // 노드를 삽입
    public void add(K key, V data) {
        if (root == null)
            root = new Node<K,V>(key, data, null, null);
        else
            addNode(root, key, data);
    }

    // 키 값이 key인 노드를 삭제
    public boolean remove(K key) {
        Node<K,V> p = root;         // 스캔 중인 노드
        Node<K,V> parent = null;    // 스캔 중인 노드의 부모 노드
        boolean isLeftChild = true; // p는 부모의 왼쪽 자식 노드인가?

        while (true) {
            if (p == null) return false;      // 더 이상 진행하지 않으면 그 키 값은 없습니다.
            int cond = comp(key, p.getKey()); // key와 노드 p의 키 값을 비교
            if (cond == 0) break;             // 같으면 검색 성공
            else {
                parent = p; // 가지로 내려가기 전에 부모를 설정
                if (cond < 0) {         // key 쪽이 작으면
                    isLeftChild = true; // 왼쪽 자식으로 내려감
                    p = p.left;         // 왼쪽 서브트리에서 검색
                } else {                // key 쪽이 크면
                    isLeftChild = false;// 오른쪽 자식으로 내려감
                    p = p.right;         // 오른쪽 서브트리에서 검색
                }
            }
        }

        if (p.left == null) { // p에는 왼쪽 자식이 없음
            if (p == root)
                root = p.right;
            else if (isLeftChild)
                parent.left = p.right;  // 부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
            else
                parent.right = p.right; // 부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
        } else if (p.right == null) {   // p에는 오른쪽 자식이 없음
            if (p == root)
                root = p.left;
            else if (isLeftChild)
                parent.left = p.left;   // 부모의 왼쪽 포인터가 왼쪽 자식을 가리킴
            else
                parent.right = p.left;  // 부모의 오른쪽 포인터가 왼쪽 자식을 가리킴
        } else {
            parent = p;
            Node<K,V> left = p.left;    // 서브트리 가운데 가장 큰 노드
            isLeftChild = true;
            while (left.right != null) { // 가장 큰 노드 left를 검색
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key;             // left의 키 값을 p로 옮김
            p.data = left.data;           // left의 데이터를 p로 옮김
            if (isLeftChild)
                parent.left = left.left;  // left를 삭제
            else
                parent.right = left.left; // left를 삭제
        }
        return true;
    }

    // node를 루트로 하는 서브트리의 노드를 키 값의 오름차순으로 출력
    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left); // 왼쪽 서브트리를 키 값의 오름차순으로 출력
            System.out.println(node.key + " " + node.data); // node를 출력
            printSubTree(node.right); // 오른쪽 서브트리를 키 값의 오름차순으로 출력
        }
    }

    // 모든 노드를 키 값의 오름차순으로 출력
    public void print() {
        printSubTree(root);
    }
}
