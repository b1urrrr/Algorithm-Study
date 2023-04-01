package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSortTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("x[%d] : ", i);
            x[i] = stdIn.nextInt();
        }

        Arrays.sort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < num; i++) System.out.printf("x[%d] = %d\n", i, x[i]);

        stdIn.close();
    }    
}
