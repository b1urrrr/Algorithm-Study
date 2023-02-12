/*
    백준 9076번 : 점수 집계
    - 풀이 유형 : 선택 정렬 (Selection Sort)
*/

import java.util.Scanner;

public class 점수_집계 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int repeat = stdIn.nextInt(); // 테스트 케이스의 개수 입력
        int[] scores = new int[5]; // 다섯 심판의 점수

        for (int i = 0; i < repeat; i++) {
            // 심판의 점수 입력
            for (int j = 0; j < 5; j++) {
                scores[j] = stdIn.nextInt();
            }

            // 선택 정렬
            for (int j = 0; j < 4; j++) {
                int least = j;
                // 최솟값 찾기
                for (int k = j + 1; k < 5; k++) {
                    if (scores[k] < scores[least]) {
                        least = k;
                    }
                }
                // 현재 값과 최솟값 위치 교환
                int temp = scores[least];
                scores[least] = scores[j];
                scores[j] = temp;
            }

            // 출력
            if (scores[3] - scores[1] >= 4) System.out.println("KIN");
            else System.out.println(scores[1] + scores[2] + scores[3]);
        }

        stdIn.close();
    }
}