public class IntStack {
    private int max;   // 스택 용량
    private int ptr;   // 스택 포인터
    private int[] stk; // 스택 본체

    // 실행 시 예외 : 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    // 생성자
    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];         // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // push
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= max)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    // pop
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // peek
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // 검색 메서드 indexOf
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--)
            if (stk[i] == x)
                return i;

        return -1;
    }

    // 스택 비우기 메서드 clear
    public void clear() {
        ptr = 0;
    }

    // 스택 용량 반환 capacity
    public int capacity() {
        return max;
    }

    // 스택 데이터 수 확인 메서드 size
    public int size() {
        return ptr;
    }

    // 스택 비어있는지 확인 메서드 IsEmpty
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택 가득 찼는지 확인 메서드 IsFull
    public boolean isFull() {
        return ptr >= max;
    }

    // 스택 안의 모든 데이터를 바닥->꼭대기 순으로 출력
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
