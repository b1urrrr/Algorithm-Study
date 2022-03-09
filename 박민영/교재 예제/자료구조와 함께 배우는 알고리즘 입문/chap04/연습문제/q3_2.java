// 해설 코드 보면서 수정한 코드
public class q3_2 {
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

    public enum AorB {
        StackA, StackB
    }

    // 생성자
    public q3_2(int capacity) {
        ptr_a = 0;
        ptr_b = capacity - 1;
        max = capacity;
        try {
            stk = new int[max];         // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // push
    public int push(AorB stack, int x) throws OverflowIntStackException {
        if (ptr_a >= ptr_b + 1) // ptr_a가 (ptr_b + 1)보다 뒤쪽 인덱스에 있는 경우 // ptr_b + 1은 스택 B의 마지막 마지막 인덱스 위치
            throw new OverflowIntStackException();
        switch (stack) {
            case StackA:
                stk[ptr_a++] = x;
                break;
            case StackB:
                stk[ptr_b--] = x;
                break;
        }
        return x;
    }

    // pop
    public int pop(AorB stack) throws EmptyIntStackException {
        int x = 0;
        switch (stack) {
            case StackA:
                if (ptr_a <= 0)
                    throw new EmptyIntStackException();
                x = stk[--ptr_a];
            case StackB:
                if (ptr_b >= max - 1)
                    throw new EmptyIntStackException();
                x = stk[++ptr_b];
        }
        return x;
    }

    // peek
    public int peek_a(AorB stack) throws EmptyIntStackException {
        int x = 0;
        switch (stack) {
            case StackA:
                if (ptr_a <= 0)
                    throw new EmptyIntStackException();
                x = stk[ptr_a - 1];
            case StackB:
                if (ptr_b >= max - 1)
                    throw new EmptyIntStackException();
                x = stk[ptr_b + 1];
        }

        return x;
    }


    // 검색 메서드 indexOf
    public int indexOf_a(AorB stack, int x) {
        switch (stack) {
            case StackA:
                for (int i = ptr_a - 1; i >= 0; i--)
                    if (stk[i] == x)
                        return i;
            case StackB:
                for (int i = ptr_b + 1; i <= max - 1; i++)
                    if (stk[i] == x)
                        return i;
        }
        return -1;
    }

    // 스택 비우기 메서드 clear
    public void clear(AorB stack) {
        switch (stack) {
            case StackA :
                ptr_a = 0;
            case StackB:
                ptr_b = 0;
        }

    }

    // 스택 용량 반환 capacity
    public int capacity() {
        return max;
    }

    // 스택 데이터 수 확인 메서드 size
    public int size(AorB stack) {
        switch (stack) {
            case StackA :
                return ptr_a;
            case StackB:
                return max - 1 - ptr_b;
        }
        return 0;
    }

    // 스택 비어있는지 확인 메서드 IsEmpty
    public boolean isEmpty(AorB stack) {
        switch (stack) {
            case StackA:
                return ptr_a <= 0;
            case StackB:
                return ptr_b >= max - 1;
        }
        return true;
    }

    // 스택 가득 찼는지 확인 메서드 IsFull
    public boolean isFull() {
        return ptr_a >= ptr_b + 1;
    }

    // 스택 안의 모든 데이터를 바닥->꼭대기 순으로 출력
    public void dump(AorB stack) {
        switch (stack) {
            case StackA:
                if (ptr_a <= 0)
                    System.out.println("스택이 비어 있습니다.");
                else {
                    for (int i = 0; i < ptr_a; i++)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
            case StackB:
                if (ptr_b >= max - 1)
                    System.out.println("스택이 비어 있습니다.");
                else {
                    for (int i = max - 1; i > ptr_b; i--)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
        }

    }
}
