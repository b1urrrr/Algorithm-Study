/*
    백준 11047번 : 동전 0
    - 문제 유형 : 그리디 알고리즘
*/

import java.io.*;
import java.util.StringTokenizer;

public class 동전_0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int num = Integer.parseInt(st.nextToken()); // 동전의 개수 입력
        int cost = Integer.parseInt(st.nextToken()); // 목표 값 입력
        int[] coins = new int[num];

        for (int i = num - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine()); // 동전의 값어치 입력
        }
        br.close();

        int count = 0;
        while (cost > 0) { // 값이 0이 될 때까지 반복
            for (int c : coins) {
                // 값어치가 큰 동전부터 사용
                if (cost >= c) {
                    cost -= c;
                    count ++;
                    break;
                }
            }
        }

        // 동전의 개수 출력
        System.out.println(count);
    }
}
