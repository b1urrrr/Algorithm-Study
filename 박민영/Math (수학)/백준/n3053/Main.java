/*
 * @author Minyeong Park
 * @date 2022.06.04.
 * 택시 기하학
 * 참고 : https://st-lab.tistory.com/89, https://itholic.github.io/kata-taxicab-circle/
 * 문제 링크 : https://www.acmicpc.net/problem/3053
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();

        System.out.printf("%6f\n", r * r * Math.PI);
        System.out.printf("%6f", (2.0 * r) * r);
    }
}
