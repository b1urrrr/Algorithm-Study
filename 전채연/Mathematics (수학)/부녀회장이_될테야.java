/*
    백준 2775번 : 부녀회장이 될테야
    - 문제 유형 : 수학
*/

import java.io.*;

public class 부녀회장이_될테야 {
    static final int SIZE = 15; // 층과 호의 최대값 + 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] residents = new int[SIZE][SIZE]; // 해당 층과 호수에 대한 거주민 수를 저장하는 2차원 배열
        // 0층 거주민 수 초기화
        for (int i = 0; i < SIZE; i++) {
            residents[0][i] = i;
        }

        // 1 ~ 14층 거주민 수 초기화
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                residents[i][j] += residents[i][j - 1] + residents[i - 1][j];
            }
        }

        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력
        for (int i = 0; i < testCase; i++) {
            int floor = Integer.parseInt(br.readLine()); // 층 입력
            int unit = Integer.parseInt(br.readLine()); // 호 입력
            bw.write(residents[floor][unit] + "\n"); // 해당 층과 호의 거주민 수 출력
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
