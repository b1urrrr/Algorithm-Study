import java.util.Scanner;

public class q7 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값 : ");
        int n = stdIn.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(i + " + ");
        }
        System.out.print("= " + sum);

    }
}
