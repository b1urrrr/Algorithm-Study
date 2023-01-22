/*
    백준 9656번 : 돌 게임 2
    - 문제 유형 : 게임 이론, 동적 계획법
*/

import java.io.*;

public class 돌_게임_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) System.out.println("SK");
        else System.out.println("CY");
    }
}
