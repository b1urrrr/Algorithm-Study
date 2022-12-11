/*
 * @author Minyeong Park
 * @date 2022.12.11.
 * 알고리즘 수업 - 병합 정렬 1
 * 원리 및 코드 참고 : https://www.acmicpc.net/board/view/105251, https://velog.io/@gogumi4502/Java-%EB%B0%B1%EC%A4%80-24060-%EC%9E%AC%EA%B7%80
 * 문제 링크 : https://www.acmicpc.net/problem/24060
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] tmp;
    static int count = 0;
    static int k;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        tmp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, n-1);
        System.out.println(result);
    }

    static void merge_sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;        // q는 p, r의 중간 지점
            merge_sort(arr, p, q);      // 전반부 정렬
            merge_sort(arr, q+1, r); // 후반부 정렬
            merge(arr, p, q, r);        // 병합
        }
    }

    // arr[p..q]와 arr[q+1..r]을 병합하여 arr[p..r]을 오름차순 정렬된 상태로 만든다.
    static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int t = 0;

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        // 왼쪽 배열 부분이 남은 경우
        while (i <= q) {
            tmp[t++] = arr[i++];
        }

        // 오른족 배열 부분이 남은 경우
        while (j <= r) {
            tmp[t++] = arr[j++];
        }

        i = p;
        t = 0;

        // 결과를 arr[p..r]에 저장
        while (i <= r) {
            count++;
            if (count == k) {
                result = tmp[t];
                break;
            }
            arr[i++] = tmp[t++];
        }
    }
}