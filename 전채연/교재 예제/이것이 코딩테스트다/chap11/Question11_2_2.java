package chap11;

import java.io.*;

public class Question11_2_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long result = 0;
        String S = br.readLine(); // 문자열 S 입력
        for (int i = 0; i < S.length(); i++) {
            int num = S.charAt(i) - '0';

            // 현재 수가 1 이하이면 덧셈
            if (result <= 1 || num <= 1) result += num;
            // 현재 수가 2 이상이면 곱셈
            else result *= num; 
        }

        // 만들어질 수 있는 가장 큰 수 출력
        System.out.println(result);
    }
}
