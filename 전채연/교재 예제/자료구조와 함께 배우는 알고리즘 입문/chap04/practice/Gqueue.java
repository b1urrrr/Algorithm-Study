// Q6

package chap04.practice;

public class Gqueue<E> {
    private int max;
    private int num;
    private int front;
    private int rear;
    private E[] que;
    
    public static class EmptyGqueueException extends RuntimeException {
        public EmptyGqueueException() { }
    }

    public static class OverflowGqueueException extends RuntimeException {
        public OverflowGqueueException() { }
    }

    // 생성자
    @SuppressWarnings("unchecked")
    public Gqueue(int capacity) {
        max = capacity;
        num = 0;
        front = rear = 0;
        try {
            que = (E[]) new Object[capacity];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 인큐 메서드
    public E enque(E x) throws OverflowGqueueException {
        if (num >= max) throw new OverflowGqueueException();
        que[rear++] = x;
        num++;
        if (rear == max) rear = 0;
        return x;
    }

    // 디큐 메서드
    public E deque() throws EmptyGqueueException {
        if (num <= 0) throw new EmptyGqueueException();
        E x = que[front++];
        num--;
        if (front == 0) front = 0;
        return x;
    }

    // 피크 메서드
    public E peek() throws EmptyGqueueException {
        if (num <= 0) throw new EmptyGqueueException();
        return que[front];
    }

    // 검색 메서드
    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            if (que[(i + front) % max] == x) return (i + front) % max;
        }
        return -1;
    }

    // 삭제 메서드
    public void clear() {
        num = front = rear = 0;
    }

    // 용량 메서드
    public int capacity() {
        return max;
    }

    // 데이터 수 메서드
    public int size() {
        return num;
    }

    // 비어있는지 검사 메서드
    public boolean isEmpty() {
        return num <= 0;
    }

    // 꽉 차 있는지 검사 메서드
    public boolean isFull() {
        return num >= max;
    }

    // 모든 데이터 출력 메서드
    public void dump() {
        if (num <= 0) System.out.println("큐가 비어 있습니다.");
        for (int i = 0; i < num; i++) {
            System.out.print(que[(i + front) % max] + " ");
        }
         {
            for (int i = 0; i < num; i++) System.out.print(que[(i+front) % max] + " ");
            System.out.println();
        }
    }
}
