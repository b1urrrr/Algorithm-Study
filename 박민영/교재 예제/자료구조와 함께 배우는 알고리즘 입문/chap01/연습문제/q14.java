import java.util.Scanner;

public class q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("사각형을 출력합니다.");
        System.out.print("단 수 : ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%c", '*');
            }
            System.out.println();
        }
    }
}
