import java.util.Scanner;

public class q4 {
    //연습문제 q4
    static int q4(int a, int b, int c) {
        if (a >= b)
            if (b >= c) return b;
            else if (a <= c) return a;
            else return c;
        else if (a > c) return a;
        else if (b > c) return c;
        else return b;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] input = new int[3];

        System.out.println("세 정수의 중앙값을 구합니다.");
        System.out.print("a의 값 : ");
        input[0] = stdIn.nextInt();
        System.out.print("b의 값 : ");
        input[1] = stdIn.nextInt();
        System.out.print("c의 값 : ");
        input[2] = stdIn.nextInt();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.println(input[i] + ", " + input[j] + ", " + input[k] + "의 중앙값은 " + q4(input[i],input[j],input[k]) + "입니다.");
                }
            }
        }
    }
}
