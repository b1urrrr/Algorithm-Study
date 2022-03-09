public class IntQueue {
    private int max;   // 큐의 용량
    private int front; // 첫 번째 요소 커서
    private int rear;  // 마지막 요소 커서
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
    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;

        try {
            que = new int[max];
        } catch (OutOfMemoryError e) { // 생성 불가능능
           max = 0;
        }
    }
}
