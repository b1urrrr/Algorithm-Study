// chap15 Q.28 고정점 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n15_28 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색 수행
        int index = binarySearch(arr, 0, n-1);

        // 결과 출력
        System.out.println(index);
    }

    // 이진 탐색 소스코드 구현(재귀 함수)
    static int binarySearch(int[] arr, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;

        System.out.println(start + " " + mid + " " + end);


        // 고정점을 찾은 경우 중간점 인덱스 반환
        if (arr[mid] == mid) return mid;
        // 중간점의 값보다 중간점 인덱스가 작은 경우 왼쪽 확인
        else if (arr[mid] > mid)
            return binarySearch(arr, start, mid - 1);
        // 중간점의 값보다 중간점 인덱스가 큰 경우 오른쪽 확인
        else
            return binarySearch(arr, mid + 1, end);
    }
}
