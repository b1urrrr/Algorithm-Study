/*
    백준 1676번 : 팩토리얼 0의 개수
    - 문제 유형 : 수학
*/

import java.io.*;
import java.math.BigInteger;

public class 팩토리얼_0의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // N 입력

        // 1부터 N을 곱하여 result에 저장
        BigInteger result = new BigInteger("1");
        for (int i = 2; i <= num; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }

        // 처음 0이 아닌 숫자가 나올 때까지의 0의 개수 카운트
        int count = 0;
        while (result.compareTo(new BigInteger("0")) > 0) {
            if (result.remainder(new BigInteger("10")).compareTo(new BigInteger("0")) == 0) {
                count++;
            } else break;
            result = result.divide(new BigInteger("10"));
        }

        // 결과 출력
        System.out.println(count);
    }
}
