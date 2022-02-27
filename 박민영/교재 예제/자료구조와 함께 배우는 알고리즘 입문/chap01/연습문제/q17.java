import java.util.Scanner;

public class q17 {
    static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = n-1; k >= i ; k--)
                System.out.print(" ");
            for (int j = 0; j < (i-1) * 2 + 1; j++)
                System.out.printf("%d", i % 10);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 단 피라미드입니까? : ");
        int input = sc.nextInt();
        spira(input);
    }
}
