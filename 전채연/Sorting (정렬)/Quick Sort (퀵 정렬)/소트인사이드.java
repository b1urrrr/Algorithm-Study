/*
    백준 3845번 : Art
    - 문제 유형 : 정렬, 문자열
    - 풀이 유형 : 퀵 정렬 (Quick Sort)
*/

import java.util.Scanner;

public class 소트인사이드 {
    // 퀵 정렬 함수
    static void quick_sort(int[] data, int start, int end) {
        // 범위가 1 이하인 경우에 종료
        if (start >= end) return;

        int pivot = start;
        int i = pivot + 1;
        int j = end;

        while (i <= j) {
            // i가 피벗보다 같거나 작으면 i 증가
            while (i <= end && data[i] <= data[pivot]) i++;
            // j가 피벗보다 같거나 크면 j 감소
            while (j > start && data[j] >= data[pivot]) j--;
            if (i > j) { // i가 j보다 커지면 pivot가 j의 값 교환
                int temp = data[pivot];
                data[pivot] = data[j];
                data[j] = temp;
            } else { // i와 j의 값 교환
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        // 피벗보다 작은 수 배열과 큰 수 배열에 대해 재귀 함수 호출
        quick_sort(data, start, j - 1);
        quick_sort(data, j + 1, end);
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String num = stdIn.next(); // 입력한 수를 문자열로 받음
        int[] numbers = new int[num.length()]; // 입력한 수를 한 자리씩 저장할 배열

        // 문자열을 정수 배열로 변환
        for (int i = 0; i < num.length(); i++) {
            numbers[i] = num.charAt(i) - '0'; // 아스키 코드 변환을 위해 '0'을 빼주어야 함
        }
        
        // 퀵 정렬 함수 호출
        quick_sort(numbers, 0, num.length() - 1);

        // 출력
        for (int i = num.length() - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
        }
        System.out.println();

        stdIn.close();
    }
}