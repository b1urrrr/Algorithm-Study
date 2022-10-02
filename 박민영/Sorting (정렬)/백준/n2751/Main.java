/*
 * @author Minyeong Park
 * @date 2022.03.10.
 * 수 정렬하기 2
 * https://www.acmicpc.net/problem/2751
 */


import java.io.*;

public class Main {
    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr,tmp,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr,tmp,start,mid);       // 앞쪽
            mergeSort(arr,tmp,mid+1,end);  // 뒤쪽
            merge(arr,tmp,start,mid,end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;    // 앞쪽 분할 배열의 시작점
        int part2 = mid + 1;  // 뒤쪽 분할 배열의 시작점
        int index = start;    // 작은 수를 새로 넣을 자리의 인덱스

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) { // 잎쪽 분할 배열의 시작점 값이 작으면
                arr[index] = tmp[part1];    // arr배열에 앞쪽 분할 배열 시작점 값을 대입
                part1++;                    // 앞쪽 분할 배열 시작점 뒤로 이동
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;                         // arr배열의 인덱스 증가
        }
        for (int i = 0; i <= mid - part1; i++) { // 앞쪽 분할 배열에서 데이터가 남아있는 경우
            arr[index + i] = tmp[part1 + i];
        }
        // 뒤쪽 분할 배열에서 데이터가 남아있는 경우는 최종 배열 arr 뒤쪽에 이미 남아있으므로 따로 구현 x
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr);
        for (int i = 0; i < num; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }
}