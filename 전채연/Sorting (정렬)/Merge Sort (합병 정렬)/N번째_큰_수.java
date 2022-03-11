/*
    백준 2693번 : N번째 큰 수
    - 문제 유형 : 정렬
    - 풀이 유형 : 합병 정렬 (Merge Sort)
*/

import java.util.Scanner;

public class N번째_큰_수 {
    static final int SIZE = 10; // 배열의 크기 상수
    static int[] sorted = new int[SIZE]; // 합병을 위한 배열

    // 합병 정렬을 위한 합병 함수
    static void merge(int[] data, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        // 앞쪽의 배열과 뒷쪽의 배열의 요소를 비교하며 작은 수를 sorted에 대입
        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                sorted[k++] = data[i++];
            } else {
                sorted[k++] = data[j++];
            }
        }

        // 비교한 뒤 요소가 남은 배열을 선택하여 sorted에 대입
        if (mid < i) {
            for (int t = j; t <= end; t++) sorted[k++] = data[t];
        } else {
            for (int t = i; t <= mid; t++) sorted[k++] = data[t];
        }
        
        // data 배열에 sorted 배열 대입
        for (int t = start; t <= end; t++) {
            data[t] = sorted[t];
        }
    }

    // 합병 정렬 함수
    static void merge_sort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(data, start, mid); // 앞 부분 배열 정렬
            merge_sort(data, mid + 1, end); // 뒷 부분 배열 정렬
            merge(data, start, mid, end); // 합병
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int testCase = stdIn.nextInt(); // 테스트 케이스 개수 입력
        int[] data = new int[SIZE]; // 배열

        // 테스트 케이수 개수만큼 반복
        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < SIZE; j++) data[j] = stdIn.nextInt(); // 배열 요소 입력
            // 합병 정렬 함수 호출
            merge_sort(data, 0, SIZE - 1);
            // 세 번째로 가장 큰 수 출력
            System.out.println(data[SIZE - 3]);
        }
    }
}