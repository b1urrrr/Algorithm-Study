// chap12 Q7.럭키 스트레이트
// 백준 18406번 문제

import java.util.Scanner;

public class n12_1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String n_str = n + "";
        String left = n_str.substring(0, n_str.length() / 2);
        String right = n_str.substring(n_str.length() / 2);

        int leftsum = 0, rightsum = 0;
        for (int i = 0; i < left.length(); i++) {
            leftsum += Integer.parseInt(left.charAt(i) + "");
        }
        for (int i = 0; i < right.length(); i++) {
            rightsum += Integer.parseInt(right.charAt(i) + "");
        }
        if (leftsum == rightsum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
