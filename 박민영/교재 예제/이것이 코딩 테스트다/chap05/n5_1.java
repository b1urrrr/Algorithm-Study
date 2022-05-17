// chap05 (1) 스택 예제
import java.util.Stack;

public class n5_1 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(5); // 5 삽입
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop();
        s.push(1);
        s.push(4);
        s.pop();

        // 스택의 최상단 원소부터 출력
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
