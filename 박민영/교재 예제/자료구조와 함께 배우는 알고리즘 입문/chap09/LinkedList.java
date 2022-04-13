import java.util.Comparator;

public class LinkedList<E> {
    // 노드
    class Node<E> {
        private E data;       // 데이터
        private Node<E> next; // 뒤쪽 포인터(다음 노드 참조)

        // 생성자
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; // 머리 노드
    private Node<E> crnt; // 선택 노드

    // 생성자
    public LinkedList() { // 노드 0개
        head = crnt = null;
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head; // 현재 스캔 중인 노드
        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) { // 검색 성공
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;                      // 다음 노드를 선택
        }
        return null;                             // 검색 실패
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        Node<E> ptr = head; // 삽입 전의 머리 노드
        head = crnt = new Node<E>(obj, ptr); // 생성한 노드를 참조하도록 업데이트함
    }

    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        if (head == null)    // 리스트가 비어 있으면
            addFirst(obj);   // 머리에 삽입
        else {
            Node<E> ptr = head;
            while(ptr.next != null)
                ptr = ptr.next;     // 계속해서 다음 노드를 가리키도록 업데이트하는 과정을 반복
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        if (head != null)          // 리스트가 비어 있지 않으면
            head = crnt = head.next;
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (head != null) {
            if (head.next == null) // 노드가 하나만 있으면
                removeFirst();     // 머리 노드를 삭제
            else {
                Node<E> ptr = head; // 스캔 중인 노드
                Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;    // pre는 삭제 후의 꼬리 노드
                crnt = pre;
            }
        }
    }

    // 노드 p를 삭제
    public void remove(Node p) {
        if (head != null) {
            if (p == head)      // p가 머리 노드면
                removeFirst();  // 머리 노드를 삭제
            else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) return; // p가 리스트에 없습니다.
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    // 현재 선택한 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear() {
        while (head != null) // 노드에 아무것도 없을 때까지
            removeFirst();   // 머리 노드를 삭제
        crnt = null;
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (crnt == null || crnt.next == null) // 리스트가 비어 있거나 선택 노드의 뒤쪽 노드가 없는 경우
            return false;                      // 이동 불가능
        crnt = crnt.next;
        return true;
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    // 모든 노드를 출력
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
