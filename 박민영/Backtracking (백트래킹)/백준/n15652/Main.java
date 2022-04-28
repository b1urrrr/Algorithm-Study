/*
 * @author Minyeong Park
 * @date 2022.04.28.
 * N과 M (4)
 * 참고 : https://st-lab.tistory.com/115#%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * 문제 링크 : https://www.acmicpc.net/problem/15652
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr; // 수열을 담는 배열
    static void func(int at, int depth) {  // at : 현재 위치 (어디서부터 시작하는지를 의미하는 변수)
        if (depth == M) {
            for (int num : arr)
                System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            func(i, depth + 1);
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        func(1, 0);
    }
}