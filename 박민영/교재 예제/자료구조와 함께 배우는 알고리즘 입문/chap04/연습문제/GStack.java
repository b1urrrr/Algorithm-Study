public class GStack<E> {
    private int max;   // 스택 용량
    private int ptr;   // 스택 포인터
    private E[] stk; // 스택 본체

    // 실행 시 예외 : 스택이 비어 있음
    public static class EmptyGStackException extends RuntimeException {
        public EmptyGStackException() { }
    }

    // 실행 시 예외 : 스택이 가득 참
    public static class OverflowGStackException extends RuntimeException {
        public OverflowGStackException() { }
    }

    // 생성자
    public GStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = (E[]) new Object[max];         // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // push
    public E push(E x) throws OverflowGStackException {
        if (ptr >= max)
            throw new OverflowGStackException();
        return stk[ptr++] = x;
    }

    // pop
    public E pop() throws EmptyGStackException {
        if (ptr <= 0)
            throw new EmptyGStackException();
        return stk[--ptr];
    }

    // peek
    public E peek() throws EmptyGStackException {
        if (ptr <= 0)
            throw new EmptyGStackException();
        return stk[ptr - 1];
    }

    // 검색 메서드 indexOf
    public int indexOf(E x) {
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
