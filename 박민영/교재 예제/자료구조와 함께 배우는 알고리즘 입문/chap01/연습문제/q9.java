import java.util.Scanner;

public class q9 {
    static int sumof (int a, int b) {
        int big = a;
        int small = b;
        if (a < b) {
            big = b;
            small = a;
        }

        int sum = 0;
        for (int i = small; i <= big; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(sumof(a,b));
    }
}
