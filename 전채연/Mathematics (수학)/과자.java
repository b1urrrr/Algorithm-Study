import java.util.Scanner;

public class 과자 {
    public static void main (String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int cost = stdIn.nextInt();
        int count = stdIn.nextInt();
        int money = stdIn.nextInt();
        
        cost *= count;
        cost -= money;
        if (cost < 0) cost = 0;
        System.out.println(cost);

        stdIn.close();
    }
}