package chap06;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

// 두 배열의 원소 교체
public class Practice6_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열 원소의 개수 N 입력
        int K = Integer.parseInt(st.nextToken()); // 바꿔치기 횟수의 최대값 K 입력
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // A 원소 입력
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken()); // B 원소 입력
        }

        // A 오름차순 정렬
        Arrays.sort(A);
        // B 내림차순 정렬
        Arrays.sort(B, Collections.reverseOrder());

        // 배열 A의 모든 원소의 합 계산
        long sum = 0;
        for (int i = 0; i < N; i++) {
            // 인덱스가 K보다 작고, A의 원소가 B의 원소보다 작으면 초기화
            if (i < K && A[i] < B[i]) A[i] = B[i];
            sum += A[i];
        }
        
        // 배열 A의 모든 원소의 합의 최댓값 출력
        System.out.println(sum);
    }
}
