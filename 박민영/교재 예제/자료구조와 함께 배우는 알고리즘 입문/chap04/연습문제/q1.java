import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64); // 최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());

            System.out.print("(1)푸시  (2)팝  (3)피크  (4)덤프 \n" +
                    "(5)검색  (6)클리어  (7)용량 확인  (8)데이터 수 확인\n" +
                    "(9)비어있는지 검사  (10)가득 찼는지 검사  (0)종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
                case 5:  // indexOf
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    int idx = s.indexOf(x);
                    System.out.println("해당 데이터는 " + idx + "번 인덱스에 있습니다.");
                    break;
                case 6: // clear
                    s.clear();
                    break;
                case 7: // capacity
                    System.out.println("스택의 용량은 " + s.capacity() + "입니다.");
                    break;
                case 8: // size
                    System.out.println("현재 스택에 들어 있는 데이터의 수는 " + s.size() + "입니다.");
                    break;
                case 9: // IsEmpty
                    System.out.println(s.isEmpty() ? "스택이 비어 있습니다." : "스택이 비어 있지 않습니다.");
                    break;
                case 10: // IsFull
                    System.out.println(s.isFull() ? "스택이 가득 차있습니다." : "스택이 가득 차지 않았습니다.");
                    break;
            }
        }
    }

}
