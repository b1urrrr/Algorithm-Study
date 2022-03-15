// Q7

package chap04.practice;

public class IntDeque {
    int max;
    int num;
    int front;
    int rear;
    int[] que;

    public class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException() { }
    }

    public class OverflowIntDequeException extends RuntimeException {
        public OverflowIntDequeException() { }
    }

    // 생성자
    public IntDeque(int capacity) {
        max = capacity;
        num = front = rear = 0;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 인큐 메서드
    public int enque(int x) throws OverflowIntDequeException {
        if (num >= max) throw new OverflowIntDequeException();
        que[rear++] = x;
        num++;
        if (rear == max) rear = 0;
        return x;
    }

    // 디큐 메서드
    public int deque() throws EmptyIntDequeException {
        if (num <= 0) throw new EmptyIntDequeException();
        int x = que[front++];
        num--;
        if (front == max) front = 0;
        return x;
    }

    // 피크 메서드
    public int peek() throws EmptyIntDequeException {
        if (num <= 0) throw new EmptyIntDequeException();
        return que[front];
    }

    // 검색 메서드
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            if (que[(i + front) % max] == x) return (i + front) % max;
        }
        return -1;
    }

    // 삭제 메서드
    public void clear() {
        num = front = rear = 0;
    }

    // 용량 반환 메서드
    public int capacity() {
        return max;
    }

    // 데이터 수 반환 메서드
    public int size() {
        return num;
    }

    // 비어있는지 검사 메서드
    public boolean isEmpty() {
        return num <= 0;
    }

    // 꽉 차있는지 검사 메서드
    public boolean isFull() {
        return num >= max;
    }

    // 모든 데이터 출력 메서드
    public void dump() {
        if (num <= 0) System.out.println("큐가 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % max] + " ");
            }
            System.out.println();
        }
    }
}
