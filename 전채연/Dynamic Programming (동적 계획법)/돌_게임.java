/*
    백준 9655번 : 돌 게임
    - 문제 유형 : 동적 계획법, 게임 이론, 수학
*/

import java.io.*;

public class 돌_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 3) {
            System.out.println("SK");
            return;
        }

        if (N == 2) {
            System.out.println("CY");
            return;
        } 

        boolean[] winner = new boolean[N + 1];
        winner[1] = winner[3] = false;
        winner[2] = true;

        for (int i = 4; i <= N; i++) winner[i] = !winner[i - 3] || !winner[i - 1];

        if (winner[N]) System.out.println("CY");
        else System.out.println("SK");
    }
}
