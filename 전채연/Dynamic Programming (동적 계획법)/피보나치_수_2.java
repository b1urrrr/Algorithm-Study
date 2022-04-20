/*
    백준 2748번 : 피보나치 수 2
    - 문제 유형 : 동적 계획법, 수학
*/

import java.io.*;
import java.math.BigInteger;

public class 피보나치_수_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n 입력
        BigInteger A = new BigInteger("0"); // 첫 번째 수
        BigInteger B = new BigInteger("1"); // 두 번째 수

        // A와 B를 한 단계씩 증가
        for (int i = 2; i <= n; i++) {
            BigInteger tmp = A;
            A = B;
            B = B.add(tmp);
        }

        // n 번째 피보나치 수 출력
        System.out.println(B);
    }
}
