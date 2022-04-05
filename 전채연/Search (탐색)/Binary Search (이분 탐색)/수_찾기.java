/*
    백준 1920번 : 수 찾기
    - 문제 유형 : 자료 구조, 이분 탐색
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 수_찾기 {
    // 이분 탐색 메서드 - 성공 : 1, 실패 : 0
    static int binSearch(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == num) return 1;
            else if (arr[mid] > num) end = mid - 1;
            else start = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 첫 번째 정수의 개수
        int[] arrA = new int[N]; // 정수 저장 배열
        
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken()); // 정수 입력
        }
        Arrays.sort(arrA); // 배열 정렬

        int M = Integer.parseInt(br.readLine()); // 두 번째 정수의 개수
        s = br.readLine();
        st = new StringTokenizer(s);

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken()); // 정수 입력
            bw.write(binSearch(arrA, num) + "\n"); // 탐색 결과 출력
        }

        br.close();
        bw.flush();
        bw.close();
    }
}