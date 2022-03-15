public class RecurX2 {
    static void recur(int n) {
        IntStack s = new IntStack(n);

        while(true) {
            if (n > 0) {
                s.push(n);
                n = n - 1;  // n값을 하나 줄임
                continue;
            }
            if (s.isEmpty() != true) { // 스택이 비어 있지 않다면
                n = s.pop();           // 저장하고 있던 스택의 값을 팝
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }
}
