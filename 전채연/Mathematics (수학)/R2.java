import java.util.Scanner;

public class R2 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n1 = stdIn.nextInt();
        int average = stdIn.nextInt();
        
        System.out.println(average * 2 - n1);
    }
}