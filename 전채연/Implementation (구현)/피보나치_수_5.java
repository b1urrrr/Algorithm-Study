import java.util.Scanner;

public class 피보나치_수_5 {
    static int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibo(n - 1) + fibo (n - 2);
    }
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int num = stdIn.nextInt();
        System.out.println(fibo(num));
    }
}