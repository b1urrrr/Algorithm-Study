import java.util.Scanner;

public class 스타후르츠 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int summer = stdIn.nextInt();
        int grow = stdIn.nextInt();
        int fruit = stdIn.nextInt();
        int cost = stdIn.nextInt();

        int day = 1 + grow;
        int count = 0;
        while (day <= summer) {
            count += fruit;
            day += grow;
        }

        System.out.println(count * cost);

        stdIn.close();
    }
}