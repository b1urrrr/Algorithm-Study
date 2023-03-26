import java.util.Scanner;

public class 세수정렬 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int a = stdIn.nextInt();
        int b = stdIn.nextInt();
        int c = stdIn.nextInt();
        
        if (a > b) {
            if (b > c) {
                System.out.printf("%d %d %d\n", c, b, a);
            } else if (c > a) {
                System.out.printf("%d %d %d\n", b, a, c);
            } else {
                System.out.printf("%d %d %d\n", b, c, a);
            }
        } else {
            if (a > c) {
                System.out.printf("%d %d %d\n", c, a, b);
            } else if (c > b) {
                System.out.printf("%d %d %d\n", a, b, c);
            } else {
                System.out.printf("%d %d %d\n", a, c, b);
            }
        }

        stdIn.close();
    }
}
