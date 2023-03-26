package chap05.practice;
import java.util.Scanner;

public class Practice5_3 {
    static int gcd(int x, int y) {
        while(y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        return x;
    }

    static int gcdArray(int[] a, int num) {
        if (num == 1)
            return a[0];
        else if (num == 2)
            return gcd(a[0], a[1]);
        else
            return gcdArray(a, num - 1);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수의 개수 : ");
        int num = stdIn.nextInt();
        int[] data = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("data[%d] : ", i);
            data[i] = stdIn.nextInt();
        }

        System.out.printf("최대공약수는 %d입니다.\n", gcdArray(data, num));

        stdIn.close();
    }    
}
