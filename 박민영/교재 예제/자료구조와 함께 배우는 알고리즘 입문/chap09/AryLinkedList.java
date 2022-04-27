import java.util.Comparator;

// 연결 리스트 클래스 (배열 커서 버전)
public class AryLinkedList<E> {
    // 노드
    class Node<E> {
        private E data; // 데이터
        private int next; // 리스트의 뒤쪽 포인터
        private int dnext; // free 리스트의 뒤쪽 포인터

        // data와 next를 설정
        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n; // 리스트 본체
    private int size; // 리스트의 용량 (가장 큰 데이터 수)
    private int max;  // 사용중인 꼬리 record
    private int head; // 머리 노드
    private int crnt; // 선택 노드
    private int deleted; // free 리스트의 머리 노드
    private static final int NULL = -1; // 다음 노드 없음 / 리스트가 가득 참

    // 생성자

    public AryLinkedList(int capacity) {
        head = crnt = max = deleted = NULL;
        try {
            n = new Node[capacity];
            for (int i = 0; i < capacity; i++)
                n[i] = new Node<E>();
            size = capacity;
        } catch (OutOfMemoryError e) {   // 배열 생성에 실패
            size = 0;
        }
    }

    // 다음에 삽입하는 record의 인덱스를 구함
    private int getInsertIndex() {
        if (deleted == NULL) {   // 삭제할 record가 없음
            if (max < size)
                return ++max;    // 새 record를 사용
            else
                return NULL;     // 용량 over (넘침)
        } else {
            int rec = deleted;      // free 리스트에서
            deleted = n[rec].dnext; // 머리 rec을 꺼냄
            return rec;
        }
    }

    // record idx를 free 리스트에 등록
    private void deleteIndex(int idx) {
        if (deleted == NULL) {   // 삭제할 record가 없음
            deleted = idx;       // idx를 free 리스트의
            n[idx].dnext = NULL; // 머리에 등록
        } else {
            int rec = deleted;   // idx를 free 리스트의
            deleted = idx;       // 머리에 삽입
            n[rec].dnext = rec;
        }
    }

    // 노드를 검색
    public E search(E obj, Comparator<? super E> c) {
        int ptr = head;         // 현재 스캔 중인 노드

        while (ptr != NULL) {
            if (c.compare(obj, n[ptr].data) == 0) {
                crnt = ptr;
                return n[ptr].data;   // 검색 성공
            }
            ptr = n[ptr].next;        // 다음 노드에 주목
        }
        return null;                  // 검색 실패
    }

    // 머리에 노드를 삽입
    public void addFirst(E obj) {
        int ptr = head;               // 삽입 전의 머리 노드
        int rec = getInsertIndex();
        if (rec != NULL) {
            head = crnt = rec;        // 인덱스 rec인 record에 삽입
            n[head].set(obj, ptr);
        }
    }

    // 꼬리에 노드를 삽입
    public void addLast(E obj) {
        if (head == NULL)  // 리스트가 비어 있으면
            addFirst(obj); // 머리에 삽입
        else {
            int ptr = head;
            while (n[ptr].next != NULL)
                ptr = n[ptr].next;
            int rec = getInsertIndex();
            if (rec != NULL) {  // 인덱스 rec인 record에 삽입
                n[ptr].next = crnt = rec;
                n[rec].set(obj, NULL);
            }
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        if (head != NULL) { // 리스트가 비어 있지 않으면
            int ptr = n[head].next;
            deleteIndex(head);
            head = crnt = ptr;
        }
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (head != NULL) {
            if (n[head].next == NULL)    // 노드가 하나만 있으면
                removeFirst();           // 머리 노드를 삭제
            else {
                int ptr = head;          // 스캔 중인 노드
                int pre = head;          // 스캔 중인 노드의 앞쪽 노드

                while (n[ptr].next != NULL) {
                    pre = ptr;
                    ptr = n[ptr].next;
                }
                n[pre].next = NULL;      // pre는 삭제 후의 꼬리 노드
                deleteIndex(pre);
                crnt = pre;
            }
        }
    }

    // record p를 삭제
    public void remove(int p) {
        if (head != NULL) {
            if (p == head) // p가 머리노드면 머리 노드를 삭제
                removeFirst();
            else {
                int ptr = head;

                while (n[ptr].next != p) {
                    ptr = n[ptr].next;
                    if (ptr == NULL) return;  // p가 리스트에 없습니다.
                }
                n[ptr].next = NULL;
                deleteIndex(ptr);
                n[ptr].next = n[p].next;
                crnt = ptr;
            }
        }
    }

    // 선택 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear() {
        while (head != NULL) // 텅 빌 때까지 머리 노드를 삭제
            removeFirst();
        crnt = NULL;
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (crnt == NULL || n[crnt].next == NULL)
            return false;  // 이동할 수 없음
        crnt = n[crnt].next;
        return true;
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if (crnt == NULL)
            System.out.println("선택 노드가 없습니다.");
        else
            System.out.println(n[crnt].data);
    }

    // 모든 노드를 출력
    public void dump() {
        int ptr = head;

        while (ptr != NULL) {
            System.out.println(n[ptr].data);
            ptr = n[ptr].next;
        }
    }
}