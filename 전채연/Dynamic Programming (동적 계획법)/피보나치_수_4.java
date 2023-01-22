/*
    백준 10826번 : 피보나치 수 4
    - 문제 유형 : 동적 계획법, 수학
*/

import java.io.*;
import java.math.BigInteger;

public class 피보나치_수_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n 입력

        if (n == 0) {
            System.out.println(0);
            return;
        }

        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }

        BigInteger A = new BigInteger("1"); // 첫 번째 수
        BigInteger B = new BigInteger("1"); // 두 번째 수

        // A와 B를 한 단계씩 증가
        for (int i = 3; i <= n; i++) {
            BigInteger tmp = A;
            A = B;
            B = B.add(tmp);
        }

        // n 번째 피보나치 수 출력
        System.out.println(B);
    }
}
