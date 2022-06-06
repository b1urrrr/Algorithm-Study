/*
    백준 15726번 : 이칙연산
    - 문제 유형 : 구현
*/

import java.io.*;
import java.util.StringTokenizer;

public class 이칙연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        double num1 = Double.parseDouble(st.nextToken());
        double num2 = Double.parseDouble(st.nextToken());
        double num3 = Double.parseDouble(st.nextToken());

        System.out.println((int) Math.max(num1 * num2 / num3, num1 / num2 * num3));
    }
}