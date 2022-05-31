// chap07 (1) : 반복문로 구현한 이진 탐색 소스코드
import java.util.Scanner;

public class n7_3 {
    // 이진 탐색 소스코드 구현 (반복문)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 원소의 개수
        int target = sc.nextInt(); // 찾고자 하는 값

        // 전체 원소 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행 결과 출력
        int result = binarySearch(arr, target, 0, n-1);
        if (result == -1)
            System.out.println("원소가 존재하지 않습니다.");
        else
            System.out.println(result + 1);
    }
}
