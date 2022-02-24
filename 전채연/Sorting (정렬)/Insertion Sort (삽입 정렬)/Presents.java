/*
    백준 13771번 : Presents
    - 풀이 유형 : 삽입 정렬 (Insertion Sort)
*/

import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        // 가격의 개수 입력
        int num = stdIn.nextInt();
        // 가격 입력
        float[] prices = new float[num];
        for (int i = 0; i < num; i++) {
            prices[i] = stdIn.nextFloat();
        }

        // 삽입 정렬
        for (int i = 1; i < num; i++) {
            float temp = prices[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 현재 값보다 큰 값들을 한 칸씩 이동함.
                if (prices[j] > temp) {
                    prices[j + 1] = prices[j];
                } else break;
            }
            // 현재 값 삽입
            prices[j + 1] = temp;
        }

        // 두 번째로 낮은 값의 가격 출력
        System.out.printf("%.2f\n", prices[1]);
    }
}
