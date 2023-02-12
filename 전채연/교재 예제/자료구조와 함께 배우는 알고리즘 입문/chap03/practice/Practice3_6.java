package chap03.practice;

import java.util.Scanner;
import java.util.Arrays;

public class Practice3_6 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.printf("x[%d] : ", i);
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = Arrays.binarySearch(x, ky);

        if (idx < 0) System.out.printf("그 값의 요소가 없습니다.\n삽입 포인트 : %d\n", (idx + 1) * -1);
        else System.out.printf("%d은(는) x[%d]에 있습니다.", ky, idx);

        stdIn.close();
    }
}
