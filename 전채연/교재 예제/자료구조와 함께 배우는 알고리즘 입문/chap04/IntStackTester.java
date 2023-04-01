package chap04;
import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.printf("현재 데이터 수 : %d/%d\n", s.size(), s.capacity());
            System.out.print("(1)푸시  (2)팝  (3)피크  (4)덤프  (0)종료 : ");
            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch(menu) {
                case 1:
                System.out.print("데이터 : ");
                x = stdIn.nextInt();
                try {
                    s.push(x);
                } catch (IntStack.OverflowIntStackException e) {
                    System.out.println("스택이 가득 찼습니다.");
                }
                System.out.println();
                break;

                case 2:
                try {
                    x = s.pop();
                    System.out.printf("팝한 데이터는 %d입니다.\n", x);
                } catch (IntStack.EmptyIntStackException e) {
                    System.out.println("스택이 비어 있습니다.");
                }
                System.out.println();
                break;

                case 3:
                try {
                    x = s.peek();
                    System.out.printf("피크한 데이터는 %d입니다.\n", x);
                } catch (IntStack.EmptyIntStackException e) {
                    System.out.println("스택이 비어 있습니다.");
                }
                System.out.println();
                break;

                case 4:
                s.dump();
                System.out.println();
                break;
            }

            stdIn.close();
        }
    }
    
}
