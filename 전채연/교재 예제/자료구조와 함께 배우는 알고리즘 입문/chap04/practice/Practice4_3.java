package chap04.practice;

public class Practice4_3 {
    int max;
    int ptrA;
    int ptrB;
    int[] stk;

    enum AorB { StackA, StackB }

    public class EmptyStackABException extends RuntimeException {
        public EmptyStackABException() { }
    }

    public class OverflowStackABException extends RuntimeException {
        public OverflowStackABException() { }
    }

    // 생성자
    public Practice4_3(int capacity) {
        max = capacity;
        ptrA = 0;
        ptrB = max - 1;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 푸쉬 메서드
    public int push (AorB stack, int x) throws OverflowStackABException {
        if (ptrA > ptrB) throw new OverflowStackABException();
        switch(stack) {
            case StackA:
                return stk[ptrA++] = x;

            default:
                return stk[ptrB--] = x;
        }
    }


    // 팝 메서드
    public int pop(AorB stack) throws EmptyStackABException {
        switch(stack) {
            case StackA:
                if (ptrA <= 0) throw new EmptyStackABException();
                return stk[--ptrA];
            
            default:
                if (ptrB >= max - 1) throw new EmptyStackABException();
                return stk[++ptrB];
        }
    }

    // 피크 메서드
    public int peek(AorB stack) throws EmptyStackABException {
        switch(stack) {
            case StackA:
                if (ptrA <= 0) throw new EmptyStackABException();
                return stk[ptrA - 1];

            default:
                if (ptrB >= max - 1) throw new EmptyStackABException();
                return stk[ptrB + 1];
        }
    }

    // 검색 메서드
    public int indexOf(AorB stack, int x) {
        switch(stack) {
            case StackA:
                for (int i = ptrA - 1; i >= 0; i--)
                    if (stk[i] == x) return i;
                return -1;

            default:
                for (int i = ptrB + 1; i < max; i++)
                    if (stk[i] == x) return i;
                return -1;
        }
    }

    // 삭제 메서드
    public void clear(AorB stack) {
        switch(stack) {
            case StackA:
                ptrA = 0;
                break;
            
            default:
                ptrB = max - 1;
                break;
        }
    }

    // 스택의 최대 크기 반환 메서드
    public int capacity() {
        return max;
    }

    // 스택에 저장된 요소 개수 반환 메서드
    public int size(AorB stack) {
        switch(stack) {
            case StackA:
                return ptrA - 1;

            default:
                return max - ptrB - 1;
        }
    }

    // 스택이 비었는지 검사하는 메서드
    public boolean isEmpty(AorB stack) {
        switch(stack) {
            case StackA:
                return ptrA == 0;

            default:
                return ptrB == max - 1;
        }
    }

    // 스택이 꽉 찼는지 검사하는 메서드
    public boolean isFull() {
        return ptrA > ptrB;
    }

    // 스택의 모든 요소 출력 메서드
    public void dump(AorB stack) throws EmptyStackABException {
        switch(stack) {
            case StackA:
                if (ptrA <= 0) throw new EmptyStackABException();
                for (int i = 0; i < ptrA; i++) System.out.print(stk[i] + " ");
                System.out.println();
                break;

            default:
                if (ptrB >= max - 1) throw new EmptyStackABException();
                for (int i = max - 1; i > ptrB; i--) System.out.print(stk[i] + " ");
                System.out.println();
        }
    }
}