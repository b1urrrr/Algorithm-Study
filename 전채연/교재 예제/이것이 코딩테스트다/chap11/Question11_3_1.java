package chap11;

import java.io.*;

public class Question11_3_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine(); // 문자열 S 입력

        int one = 0; // 연속된 1의 개수
        int zero = 0; // 연속된 0의 개수

        if (S.charAt(0) - '0' == 0) zero++;
        else one++;

        for (int i = 1; i < S.length(); i++) {
            // 같은 문자가 반복된 경우 무시
            if (S.charAt(i - 1) == S.charAt(i)) continue;

            // 이전과 다른 문자가 입력된 경우 개수 증가
            if (S.charAt(i) - '0' == 0) zero++;
            else one++;
        }

        // 다솜이가 해야 하는 행동의 최소 횟수 (0, 1 중 개수가 적은 문자의 개수) 출력
        System.out.println(Math.min(one, zero));
    }
}
