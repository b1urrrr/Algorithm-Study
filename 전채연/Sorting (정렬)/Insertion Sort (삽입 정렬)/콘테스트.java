/*
    백준 5576번 : 콘테스트
    - 풀이 유형 : 삽입 정렬 (Insertion Sort)
*/

import java.util.Scanner;

public class 콘테스트 {
    // 배열의 최댓값 3개의 합을 반환하는 함수
    static int max3(int[] scores, int count) {
        // 삽입 정렬
        for (int i = 1; i < count; i++) {
            int temp = scores[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (scores[j] > temp) scores[j + 1] = scores[j];
                else break;
            }
            scores[j + 1] = temp;
        }
        // 최댓값 3개의 합 반환
        return scores[count - 1] + scores[count - 2] + scores[count - 3];
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] W = new int[10]; // W 대학의 득점 배열
        int[] K = new int[10]; // K 대학의 득점 배열
        // W 대학 득점 입력
        for (int i = 0; i < 10; i++) {
            W[i] = stdIn.nextInt();
        }
        // K 대학 득점 입력
        for (int i = 0; i < 10; i++) {
            K[i] = stdIn.nextInt();
        }
        
        // 출력
        System.out.printf("%d ", max3(W, 10));
        System.out.print(max3(K, 10));

        stdIn.close();
    }
}