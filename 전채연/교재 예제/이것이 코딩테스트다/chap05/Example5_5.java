package chap05;

public class Example5_5 {
    static int factorial_iterative(int n) {
        int result = 1;
        for (int i = 1; i < n + 1; i++)
            result *= i;
        return result;
    }

    static int factorial_recursive(int n) {
        if (n <= 1)
            return 1;
        
        return n * factorial_recursive(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("반복적으로 구현 : " + factorial_iterative(5));
        System.out.println("재귀적으로 구현 : " + factorial_recursive(5));
    }
}
