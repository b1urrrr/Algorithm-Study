import java.util.Scanner;

public class 상근날드 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int burger = 2000;
        int beverage = 2000;

        for (int i = 0; i < 3; i++) {
            burger = Math.min(burger, stdIn.nextInt());
        }

        for (int i = 0; i < 2; i++) {
            beverage = Math.min(beverage, stdIn.nextInt());
        }

        System.out.println(burger + beverage - 50);
    }
}