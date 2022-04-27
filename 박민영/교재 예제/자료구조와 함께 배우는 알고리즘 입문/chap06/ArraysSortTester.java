import java.util.Arrays;
import java.util.Scanner;

public class ArraysSortTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; // 배열의 크기는 num입니다.

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        Arrays.sort(x); // 배열 x를 정렬합니다

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < num; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
