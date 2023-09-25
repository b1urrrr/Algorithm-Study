/*
 * @author Minyeong Park
 * @date 2023.09.24.
 * 삼각형 외우기
 * 문제 링크 : https://www.acmicpc.net/problem/10101
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        if (a + b + c != 180) {
            System.out.println("Error");
        } else if (!(a == b || a == c || b == c)) {
            System.out.println("Scalene");
        } else if (a == 60 && b == 60 && c == 60) {
            System.out.println("Equilateral");
        } else {
            System.out.println("Isosceles");
        }
    }
}