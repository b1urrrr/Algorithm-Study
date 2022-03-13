// Q4

package chap04.practice;

public class IntAryQueue {
    private int max;
    private int num;
    private int[] que;

    public class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException() { }
    }

    public class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException() { }
    }

    // 생성자
    public IntAryQueue(int capacity) {
        max = capacity;
        num = 0;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 인큐 메서드
    public int enque(int x) throws OverflowIntAryQueueException {
        if (num >= max) throw new OverflowIntAryQueueException();
        return que[num++] = x;
    }

    // 디큐 메서드
    public int deque() throws EmptyIntAryQueueException {
        if (num <= 0) throw new EmptyIntAryQueueException();
        int output = que[0];
        for (int i = 0; i < num - 1; i++) que[i] = que[i + 1];
        num--;
        return output;
    }

    // 다음으로 디큐되는 값 반환 메서드
    public int peek() throws EmptyIntAryQueueException {
        if (num <= 0) throw new EmptyIntAryQueueException();
        return que[0];
    }

    // 검색 메서드
    public int indexOf(int x) {
        for (int i = 0; i < num; i++)
            if (que[i] == x) return i;
        return -1;
    }

    // 삭제 메서드
    public void clear() {
        num = 0;
    }

    // 큐의 용량 반환 메서드
    public int capacity() {
        return max;
    }

    // 큐에 입력된 요소 개수 반환 메서드
    public int size() {
        return num;
    }

    // 큐가 비었는지 검사하는 메서드
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐가 꽉 찼는지 검사하는 메서드
    public boolean isFull() {
        return num >= max;
    }

    // 큐에 저장된 모든 요소 출력 메서드
    public void dump() throws EmptyIntAryQueueException{
        if (num <= 0) new EmptyIntAryQueueException();
        for (int i = 0; i < num; i++) System.out.print(i + " ");
        System.out.println();
    }
}