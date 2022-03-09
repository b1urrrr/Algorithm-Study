public class IntAryQueue {
    private int max;   // 큐 용량
    private int num;   // 현재 데이터 수
    private int[] que; // 큐 본체

    // 실행 시 예외 : 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() { }
    }

    // 실행 시 예외 : 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }

    // 생성자
    public IntAryQueue(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[max];         // 큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // enqueue
    public int enqueue(int x) throws OverflowIntQueueException {
        if (num >= max)
            throw new OverflowIntQueueException();
        return que[num++] = x;
    }

    // dequeue
    public int dequeue() throws EmptyIntQueueException { // 해설 코드 참고해서 수정함
        if (num <= 0)
            throw new EmptyIntQueueException();
        int del_num = que[0];

        for (int i = 1; i < num; i++) {
            que[i-1] = que[i];
        }
        num--;
        return del_num;
    }

    // peek
    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[num - 1];
    }

    // 검색 메서드 indexOf
    public int indexOf(int x) {
        for (int i = num - 1; i >= 0; i--)
            if (que[i] == x)
                return i;

        return -1;
    }

    // 스택 비우기 메서드 clear
    public void clear() {
        num = 0;
    }

    // 스택 용량 반환 capacity
    public int capacity() {
        return max;
    }

    // 스택 데이터 수 확인 메서드 size
    public int size() {
        return num;
    }

    // 스택 비어있는지 확인 메서드 IsEmpty
    public boolean isEmpty() {
        return num <= 0;
    }

    // 스택 가득 찼는지 확인 메서드 IsFull
    public boolean isFull() {
        return num >= max;
    }

    // 스택 안의 모든 데이터를 바닥->꼭대기 순으로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }
}
