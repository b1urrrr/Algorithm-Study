/*
 * @author Minyeong Park
 * @date 2022.07.16.
 * 부녀회장이 될테야 (다른 코드 공부)
 * 출처 : https://st-lab.tistory.com/78
 * 문제 링크 : https://www.acmicpc.net/problem/2775
 */

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 아파트 생성 (미리 계산해둠!)
        int[][] APT = new int[15][15];

        for (int i = 0; i < 15; i++) {
            APT[i][1] = 1; // i층 1호
            APT[0][i] = i; // 0층 i호
        }

        for (int i = 1; i < 15; i++) { // 1층부터 14층까지
            for (int j = 2; j < 15; j++) { // 2호부터 14호까지
                APT[i][j] = APT[i][j-1] + APT[i-1][j];
            }
        }

        // 테스트 부분
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(APT[k][n]);
        }
    }
}