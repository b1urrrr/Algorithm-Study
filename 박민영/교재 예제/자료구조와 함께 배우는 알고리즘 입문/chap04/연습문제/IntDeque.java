public class IntDeque {
    private int max;   // 큐의 용량
    private int front; // 첫 번째 요소 커서
    private int rear;  // 마지막 요소 커서
    private int num;   // 현재 데이터 수
    private int[] que; // 덱 본체

    enum FrontOrBack { // 앞에서 동작할지 뒤에서 동작할지
        Front, Back
    }

    // 실행 시 예외 : 덱이 비어 있음
    public class EmptyDeckException extends RuntimeException {
        public EmptyDeckException() { }
    }

    // 실행 시 예외 : 덱이 가득 참
    public class OverflowDeckException extends RuntimeException {
        public OverflowDeckException() { }
    }

    // 생성자
    public IntDeque(int capacity) {
        num = front = rear = 0;
        max = capacity;

        try {
            que = new int[max];
        } catch (OutOfMemoryError e) { // 생성 불가능능
           max = 0;
        }
    }

    // 큐에 데이터를 인큐
    public int enque(FrontOrBack fob, int x) throws OverflowDeckException {
        if (num >= max)
            throw new OverflowDeckException(); // 큐가 가득 참
        if (fob == FrontOrBack.Front) { // 앞에서 인큐
            num++;
            if (--front < 0) front = max - 1; // 앞쪽이 가득 차면 뒤쪽에 추가
            que[front] = x;
        }
        else {                        // 뒤에서 인큐
            que[rear++] = x;
            num++;
            if (rear == max) rear = 0;
        }
        return x;
    }

    // 디큐
    public int deque(FrontOrBack fob) throws EmptyDeckException {
        if (num <= 0)
            throw new EmptyDeckException();
        int x = 0;
        if (fob == FrontOrBack.Front) { // 앞쪽에서 디큐해야 하는 경우
            x = que[front++];
            num--;
            if (front == max) front = 0;
        }
        else {                          // 뒤쪽에서 디큐해야 하는 경우
            x = que[--rear];
            num--;
            if (rear < 0) rear = max - 1;
        }
        return x;
    }

    // peek
    public int peek(FrontOrBack fob) throws EmptyDeckException {
        if (num <= 0)
            throw new EmptyDeckException();
        int x = 0;
        if (fob == FrontOrBack.Front) {
            x = que[front];
        }
        else {
            x = que[rear == 0 ? max - 1 : rear - 1];
        }
        return x;
    }

    // 큐에서 x를 검색하여 인덱스 (찾지 못하면 -1)를 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    // 큐 비우기
    public void clear() {
        num = front = rear = 0;
    }

    // 큐의 용량을 반환
    public int capacity() {
        return max;
    }

    // 큐에 쌓여 있는 데이터 수를 반환
    public int size() {
        return num;
    }

    // 큐 비어 있는지
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐 가득 찼는지
    public boolean isFull() {
        return num >= max;
    }

    // 큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i+front) % max] + " ");
            System.out.println();
        }
    }

    // 연습문제 5번 - 임의의 데이터를 검색하는 search 메서드 추가하기
    // 큐 안에서 몇 번째에 있는 가를 양수로 반환 (큐의 프런트에 있는 경우는 1로)
    // 검색 실패할 경우는 0을 반환
    public int search(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx - front + 1;
        }
        return 0;
    }
}
