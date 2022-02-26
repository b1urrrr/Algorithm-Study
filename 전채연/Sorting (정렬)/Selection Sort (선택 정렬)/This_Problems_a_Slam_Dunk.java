/*
    백준 17851번 : This Problem's a Slam Dunk
    - 풀이 유형 : 선택 정렬 (Selection Sort)
*/

import java.util.Scanner;

public class This_Problems_a_Slam_Dunk {
    public static final int NUM_OF_PLAYERS = 5; // 플레이어 인원 상수

    // 선택 정렬
    static void selection_sort(int[] data) {
        for (int i = 0; i < NUM_OF_PLAYERS - 1; i++) {
            int least = i;
            for (int j = i + 1; j < NUM_OF_PLAYERS; j++) {
                if (data[j] < data[least]) least = j;
            }
            int temp = data[least];
            data[least] = data[i];
            data[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] StateU = new int[NUM_OF_PLAYERS]; // StatU 플레이어들의 키 배열
        int[] UState = new int[NUM_OF_PLAYERS]; // UState 플레이어들의 키 배열

        // 플레이어 키 입력
        for (int i = 0 ; i < NUM_OF_PLAYERS; i++) {
            StateU[i] = stdIn.nextInt();
        }
        for (int i = 0 ; i < NUM_OF_PLAYERS; i++) {
            UState[i] = stdIn.nextInt();
        }

        // 선택 정렬 함수 호출
        selection_sort(StateU);
        selection_sort(UState);

        // UState 플레이어보다 StateU 플레이어가 키가 더 큰 경우 계산
        int count = 0;
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            if (StateU[i] > UState[i]) count++;
        }

        // 출력
        System.out.println(count);
    }
}
