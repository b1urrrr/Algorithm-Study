/*
    백준 1929번 : 소수 구하기
    - 문제 유형 : 수학, 에라토스테네스의 체
*/

import java.io.*;

public class 소수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정수 N 입력

        while(N > 1) {
            for (int i = 2; i <= N; i++) {
                if (N % i == 0) {
                    N /= i;
                    System.out.println(i); // 인수 출력
                    break;
                }
            }
        }
    }
}
