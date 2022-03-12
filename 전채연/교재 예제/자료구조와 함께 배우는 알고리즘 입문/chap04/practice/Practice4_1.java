package chap04.practice;
import java.util.Scanner;

public class Practice4_1 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack stack = new IntStack(64);

        while (true) {
            System.out.printf("현재 데이터 수 : %d/%d\n", stack.size(), stack.capacity());
            System.out.print("(1) 푸시  (2) 팝  (3) 피크  (4) 덤프  (5) 검색  (6) 삭제  (0) 종료 : ");
            
            int input = stdIn.nextInt();
            if (input == 0) break;
            switch(input) {
                case 1: // 푸시
                    System.out.print("데이터 : ");
                    try {
                        stack.push(stdIn.nextInt());
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    System.out.println();
                    break;

                case 2: // 팝
                    try {
                        System.out.printf("팝한 데이터는 %d입니다.\n\n", stack.pop());
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.\n");
                    }
                    break;
                
                case 3: // 피크
                    try {
                        System.out.printf("피크한 데이터는 %d입니다.\n\n", stack.peek());
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.\n");
                    }
                    break;

                case 4: // 덤프
                    stack.dump();
                    System.out.println();
                    break;

                case 5: // 검색
                    System.out.print("검색할 값 : ");
                    int idx = stdIn.nextInt();
                    if (idx == -1) System.out.printf("%d가 존재하지 않습니다.\n\n", idx);
                    else System.out.printf("stack[%d] = %d\n\n", stack.indexOf(idx), idx);
                    break;

                case 6: // 삭제
                    stack.clear();
                    System.out.println("스택의 모든 요소가 삭제되었습니다.\n");
                    break;
            }
        }
    }
}
