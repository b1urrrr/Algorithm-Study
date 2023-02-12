import java.util.Scanner;

public class 연세대학교 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        if (n == 0) System.out.println("YONSEI");
        else System.out.println("Leading the Way to the Future");

        stdIn.close();
    }
}