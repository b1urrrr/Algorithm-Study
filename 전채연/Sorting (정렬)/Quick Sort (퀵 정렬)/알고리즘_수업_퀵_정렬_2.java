/*
    백준 24091번 : 알고리즘 수업 - 퀵 정렬 2
    - 풀이 유형 : 퀵 정렬 (Quick Sort)
*/
import java.util.Scanner;

public class 알고리즘_수업_퀵_정렬_2 {
    static int exchange = -1; // 남은 교환 횟수

    // 퀵 정렬 함수
    static void quick_sort(int[] data, int start, int end) {
        if (exchange == 0) return; // 남은 교환 횟수가 0이면 종료

        // 정렬 범위가 2 이상인 경우만 실행
        if (start < end) {
            int pivot = data[end]; // 기준(피벗)
            int i = start - 1;
            int j = start;

            // 기준보다 작은 수들을 찾아 앞쪽 요소와 교환
            for ( ; j < end; j++) {
                if (data[j] <= pivot) {
                    int temp = data[++i];
                    data[i] = data[j];
                    data[j] = temp;
                    if (--exchange == 0) return; // 남은 교환 횟수 감소
                }
            }

            // 모든 수가 기준보다 작은 경우를 제외하고 피벗 이동
            if (data[i + 1] != pivot) {
                int temp = data[i + 1];
                data[i + 1] = pivot;
                data[end] = temp;
                if (--exchange == 0) return; // 남은 교환 횟수 감소
            }
            int mid = i + 1; // 피벗의 위치
            quick_sort(data, start, mid - 1); // 피벗보다 작은 수들 퀵 정렬
            quick_sort(data, mid + 1, end); // 피벗보다 큰 수들 퀵 정렬
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int size = stdIn.nextInt(); // 배열의 크기
        exchange = stdIn.nextInt(); // 교환 횟수
        int[] data = new int[size];

        // 배열의 원소들 입력
        for (int i = 0; i < size; i++) data[i] = stdIn.nextInt();

        // 퀵 정렬 함수 호출
        quick_sort(data, 0, size - 1);

        if (exchange > 0) System.out.println(-1); // 정렬 후에도 교환 횟수가 남은 경우 -1 출력
        else for (int i = 0; i < size; i++ )
            System.out.printf("%d ", data[i]); // 배열 출력
        System.out.println();
    }
}
