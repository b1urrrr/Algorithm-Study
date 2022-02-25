import java.util.Scanner;

public class q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a의 값 : ");
        int a = sc.nextInt();
        int b;
        do {
            System.out.print("b의 값 : ");
            b = sc.nextInt();
            if (a >= b) System.out.println("a보다 큰 값을 입력하세요!");
        } while (a >= b);

        System.out.println("b-a는 " + (b-a) + "입니다.");
    }
}
