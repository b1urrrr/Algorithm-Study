import java.util.Scanner;

public class SASA_모형을_만들어보자 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        
        int max = Math.min(n, m);
        System.out.println(max / 2);
    }
}
