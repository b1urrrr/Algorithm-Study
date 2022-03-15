import java.util.Scanner;

public class Hanoi {
    // no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);  // 시작 기둥에서 중간 기둥으로 옮기기
                                  // 기둥 번호의 합이 1+2+3 = 6 이므로 시작 기둥, 목표 기둥이 어느 기둥이더라도 중간 기둥은 6-x-y로 구할 수 있음
        System.out.println("원반[" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 옮김");

        if (no > 1)
            move(no - 1, 6 - x - y, y); // 중간 기둥에서 목표 기둥으로 옮기기
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.println("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3); // 1번 기둥의 n개의 원반을 3번 기둥으로 옮김
    }
}
