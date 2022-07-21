package chap12;

import java.io.*;

public class Question12_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine(); // 현재 점수
        int halfOfLength = N.length() / 2; // N의 자릿수의 반

        int sum = 0;

        // 왼쪽 부분의 각 자릿수의 합 덧셈
        for (int i = 0; i < halfOfLength; i++) {
            sum += N.charAt(i) - '0';
        }

        // 오른쪽 부분의 각 자릿수의 합 뺄셈
        for (int i = halfOfLength; i < N.length(); i++) {
            sum -= N.charAt(i) - '0';
        }

        // 결과가 0이면 LUCKY, 아니면 READY 출력
        if (sum == 0) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
