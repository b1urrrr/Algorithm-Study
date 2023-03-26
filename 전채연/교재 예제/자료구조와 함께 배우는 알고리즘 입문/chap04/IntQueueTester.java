package chap04;
import java.util.Scanner;

public class IntQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue s = new IntQueue(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.print("(1)인큐  (2)디큐  (3)피크  (4)덤프  (0)종료 : ");
            
            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch(menu) {
                case 1: // 인큐
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.enque(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    System.out.println();
                    break;

                case 2: // 디큐
                    try {
                        x = s.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    System.out.println();
                    break;

                case 3: // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    System.out.println();
                    break;
                
                case 4: // 덤프
                    s.dump();
                    System.out.println();
                    break;
            }
        }

        stdIn.close();
    }    
}
