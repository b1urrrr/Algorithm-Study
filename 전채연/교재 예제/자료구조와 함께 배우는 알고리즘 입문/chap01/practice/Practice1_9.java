package chap01.practice;
import java.lang.Math;

public class Practice1_9 {
    static int sumof(int a, int b) {
        int sum = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("3과 5 사이의 모든 정수의 합 : " + sumof(3, 5));
        System.out.println("6과 4 사이의 모든 정수의 합 : " + sumof(6, 4));
    }
}
