/*
    백준 24092번 : 알고리즘 수업 - 퀵 정렬 3
    - 문제 유형 : 정렬, 애드 혹, 해싱
    - 풀이 유형 : 퀵 정렬 (Quick Sort)
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 알고리즘_수업_퀵_정렬_3 {
    static int A[]; // 배열 A
    static int B[]; // 배열 B
    static boolean result = false; // 배열 A와 배열 B가 같은 경우 발생 여부

    // 배열 A와 B의 비교 함수
    static boolean compare() {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) return false;
        }
        return true;
    }

    // 퀵 정렬을 위한 분할 함수
    static int partition(int[] data, int start, int end) {
        int pivot = data[end];
        int i = start - 1;
        int j = start;
        for ( ; j < end; j++) {
            // 자신과 교환하는 경우에는 compare 함수를 호출하지 않음
            if (data[j] <= pivot && data[++i] != data[j]) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                result = result || compare();
                if (result) return -1;
            }
        }
        if (i + 1 != end) {
            int temp = pivot;
            data[end] = data[i + 1];
            data[i + 1] = temp;
            result = result || compare();
            if (result) return -1;
        }
        return i + 1;
    }

    // 퀵 정렬 함수
    static void quick_sort(int[] data, int start, int end) {
        if (result) return;
        if (start < end) {
            int pivot = partition(data, start, end);
            quick_sort(data, start, pivot - 1);
            quick_sort(data, pivot + 1, end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine()); // 배열의 크기 입력
        A = new int[size];
        B = new int[size];

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        // 배열 A의 원소들 입력
        for (int i = 0; i < size; i++) A[i] = Integer.parseInt(st.nextToken());
        
        s = br.readLine();
        st = new StringTokenizer(s);
        //배열 B의 원소들 입력
        for (int i = 0; i < size; i++) B[i] = Integer.parseInt(st.nextToken());

        result = compare(); // A와 B가 동일한 배열인지 확인
        if (!result) quick_sort(A, 0, size - 1); // 동일하지 않으면 A 배열에 대해 퀵 정렬 함수 호출

        // 출력
        bw.write(Integer.toString(result? 1 : 0));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}
