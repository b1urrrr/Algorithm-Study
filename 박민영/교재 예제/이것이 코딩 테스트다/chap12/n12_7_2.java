// chap12 Q7.럭키 스트레이트
// 백준 18406번 문제
// 다른 풀이(같은 원리이긴 한데 변수를 더 적게 사용하셨길래..)

import java.util.Scanner;

public class n12_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n_str = sc.next();

        int summary = 0;
        // 왼쪽 부분의 자릿수의 합 더하기
        for (int i = 0; i < n_str.length() / 2; i++) {
            summary += Integer.parseInt(n_str.charAt(i) + "");
        }
        // 오른쪽 부분의 자릿수의 합 빼기
        for (int i = n_str.length() / 2; i < n_str.length(); i++) {
            summary -= Integer.parseInt(n_str.charAt(i) + "");
        }
        if (summary == 0) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
