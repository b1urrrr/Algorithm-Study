import java.util.Scanner;

public class Main {
    public static void main(String[] main) {
        Scanner sc = new Scanner(System.in);
        int order = sc.nextInt();
        int numerator = 1;
        int denominator = 1;
        boolean increase = true;

        for (int i = order; i > 1; i--) {
            if (increase) {
                if (numerator == 1) {
                    denominator++;
                    increase = false;
                    continue;
                }
                numerator--;
                denominator++;
            } else {
                if (denominator == 1) {
                    numerator++;
                    increase = true;
                    continue;
                }
                numerator++;
                denominator--;
            }
        }

        System.out.print(numerator + "/" + denominator);
    }
}
