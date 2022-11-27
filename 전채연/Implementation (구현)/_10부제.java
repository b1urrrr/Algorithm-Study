import java.util.Scanner;

public class _10부제 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int day = stdIn.nextInt();
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (stdIn.nextInt() % 10 == day) count++;
        }

        System.out.println(count);
    }
}