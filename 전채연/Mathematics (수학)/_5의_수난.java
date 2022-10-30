/*
    백준 23037번 : 5의 수난
    - 문제 유형 : 수학, 구현
*/

import java.io.*;

public class _5의_수난 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            double num = number.charAt(i) - '0';
            sum += Math.pow(num, 5.0);
        }

        System.out.println(sum);
    }
}

