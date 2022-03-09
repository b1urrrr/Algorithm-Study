public class q3 {
    private int max;   // 스택 용량
    private int ptr_a;   // A 스택 포인터 (스택에 쌓여 있는 데이터 수)
    private int ptr_b;   // B 스택 포인터 (스택에 쌓여 있는 데이터 수)
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
    public q3(int capacity) {
        ptr_a = 0;
        ptr_b = capacity - 1;
        max = capacity;
        try {
            stk = new int[max];         // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // push_a
    public int push_a(int x) throws OverflowIntStackException {
        if (ptr_a >= ptr_b + 1) // ptr_a가 (ptr_b + 1)보다 뒤쪽 인덱스에 있는 경우 // ptr_b + 1은 스택 B의 마지막 마지막 인덱스 위치
            throw new OverflowIntStackException();
        return stk[ptr_a++] = x;
    }

    // push_b
    public int push_b(int x) throws OverflowIntStackException {
        if (ptr_a >= ptr_b + 1)
            throw new OverflowIntStackException();
        return stk[ptr_b--] = x;
    }

    // pop_a
    public int pop_a() throws EmptyIntStackException {
        if (ptr_a <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr_a];
    }

    // pop_b
    public int pop_b() throws EmptyIntStackException {
        if (ptr_b >= max - 1)
            throw new EmptyIntStackException();
        return stk[++ptr_b];
    }

    // peek_a
    public int peek_a() throws EmptyIntStackException {
        if (ptr_a <= 0)
            throw new EmptyIntStackException();
        return stk[ptr_a - 1];
    }

    // peek_b
    public int peek_b() throws EmptyIntStackException {
        if (ptr_b >= max - 1)
            throw new EmptyIntStackException();
        return stk[ptr_b + 1];
    }

    // 검색 메서드 indexOf_a
    public int indexOf_a(int x) {
        for (int i = ptr_a - 1; i >= 0; i--)
            if (stk[i] == x)
                return i;

        return -1;
    }

    // 검색 메서드 indexOf_b
    public int indexOf_b(int x) {
        for (int i = ptr_b + 1; i <= max - 1; i++)
            if (stk[i] == x)
                return i;

        return -1;
    }

    // 스택 비우기 메서드 clear_a
    public void clear_a() {
        ptr_a = 0;
    }

    // 스택 비우기 메서드 clear_b
    public void clear_b() {
        ptr_b = 0;
    }

    // 스택 용량 반환 capacity
    public int capacity() {
        return max;
    }

    // 스택 데이터 수 확인 메서드 size_a
    public int size_a() {
        return ptr_a;
    }

    // 스택 데이터 수 확인 메서드 size_b
    public int size_b() {
        return max - 1 - ptr_b;
    }

    // 스택 비어있는지 확인 메서드 IsEmpty_a
    public boolean isEmpty_a() {
        return ptr_a <= 0;
    }

    // 스택 비어있는지 확인 메서드 IsEmpty_b
    public boolean isEmpty_b() {
        return ptr_b >= max - 1;
    }

    // 스택 가득 찼는지 확인 메서드 IsFull
    public boolean isFull() {
        return ptr_a >= ptr_b + 1;
    }

    // 스택 안의 모든 데이터를 바닥->꼭대기 순으로 출력
    public void dump_a() {
        if (ptr_a <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr_a; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }

    public void dump_b() {
        if (ptr_b >= max - 1)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = max - 1; i > ptr_b; i--)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
