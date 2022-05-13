/*
    백준 1010번 : 다리 놓기
    - 문제 유형 : 수학
*/

import java.io.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class 다리_놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine()); // 테스트케이스 개수 입력
        // 테스트케이스 개수만큼 반복
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int west = Integer.parseInt(st.nextToken()); // 서쪽 사이트 개수 입력
            int east = Integer.parseInt(st.nextToken()); // 동쪽 사이트 개수 입력
            BigInteger result = BigInteger.ONE; // 결과 저장 변수

            // east C west 계산
            for (int j = east; j > east - west; j--) {
                result = result.multiply(new BigInteger(String.valueOf(j))); // east - west + 1부터 east까지의 수를 곱함
            }
            for (int j = west; j > 1; j--) {
                result = result.divide(new BigInteger(String.valueOf(j))); // 1부터 west까지의 수를 나눔
            }

            // 결과 출력
            bw.write(result + "\n");
        }
        bw.flush();
    }
}