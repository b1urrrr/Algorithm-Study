/*
    백준 2959번 : 거북이
    - 풀이 유형 : 삽입 정렬 (Insertion Sort)
*/

import java.util.Scanner;

public class 거북이 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] steps = new int[4]; // 걸음의 수 배열
        // 네 정수 입력
        for (int i = 0; i < 4; i++) {
            steps[i] = stdIn.nextInt(); 
        }

        // 삽입 정렬
        for(int i = 1; i < 4; i++) {
            int temp = steps[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (steps[j] > temp) steps[j + 1] = steps[j];
                else break;
            }
            steps[j + 1] = temp;
        }

        // 가장 큰 직사각형은 (두 번째로 가장 큰 값) * (네 번째로 가장 큰 값)이므로 이를 출력
        System.out.println(steps[2] * steps[0]);
    } 
}