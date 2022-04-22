/*
 * @author Minyeong Park
 * @date 2022.04.20. & 22.
 * 좌표 압축 (병합 정렬로 푼 것)
 * 풀이 참고 : https://st-lab.tistory.com/279
 * 병합정렬 코드 참고 : https://st-lab.tistory.com/233
 * 문제 링크 : https://www.acmicpc.net/problem/18870
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static int[] sorted; // 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static void merge_sort(int[] a) {
        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    public static void merge_sort(int[] a, int left, int right) {
        if (left == right) return;

        int mid = (left + right) / 2; // 절반 위치

        merge_sort(a, left, mid);           // 절반 중 왼쪽 리스트
        merge_sort(a, mid + 1, right); // 절반 중 오른쪽 리스트
        merge(a, left, mid, right);        // 병합 작업
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;     // 왼쪽 부분리스트 시작점
        int r = mid + 1;  // 오른쪽 부분리스트 시작점
        int idx = left;   // 정렬되어서 채워지는 배열의 인덱스

        while (l <= mid && r <= right) {
            if (a[l] <= a[r]) {  // 왼쪽 부분리스트 요소가 더 작은 경우
                sorted[idx] = a[l];
                l++;
                idx++;
            } else {      // 오른쪽 부분리스트 요소가 더 작은 경우
                sorted[idx] = a[r];
                r++;
                idx++;
            }
        }

        if (l > mid) { // 왼쪽 부분리스트 요소들은 다 넣었고 오른쪽 부분리스트 요소들만 그대로 넣으면 되는 경우
            while (r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        } else {       // 오른쪽 부분리스트 요소들은 다 넣었고 왼쪽 부분리스트 요소들만 그대로 넣으면 되는 경우
            while (l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        // 정렬된 새 배열을 기존의 배열에 복사하여 옮겨줌
        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sort = arr.clone();
        merge_sort(sort);

        HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>(); // 랭크를 매길 HashMap

        // 정렬된 배열을 순회하면서 map에 넣어준다
        int rank = 0;
        for (int v : sort) {
            if (!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++; // map에 넣고나면 다음 순위를 가리킬 수 있도록 1을 더함
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 원본 배열을 차례대로 순회하면서 해당 원소에 대한 rank를 가져온다
        for (int key : arr) {
            bw.write(rankingMap.get(key) + " "); // 원본 배열 원소에 대한 value(rank)를 가져온다
        }
        bw.flush();
    }
}
