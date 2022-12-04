package chap15;

import java.io.*;
import java.util.*;

public class Question15_27 {
    static final int MAX = (int) 1e6 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 원소의 개수 N 입력
        int x = Integer.parseInt(st.nextToken()); // 탐색하려는 원소 x 입력
        int[] arr = new int[MAX];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())]++; // 수열의 원소 개수 증가
        }

        // 값이 x인 원소의 개수 출력 (원소가 하나도 없다면 -1 출력)
        if (arr[x] == 0) System.out.println(-1);
        else System.out.println(arr[x]);
    }
}
