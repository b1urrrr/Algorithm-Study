import java.util.Scanner;

public class _16진수 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String A = stdIn.next();
        int num = Integer.parseInt(A, 16);
        System.out.println(num);

        stdIn.close();
    }
}