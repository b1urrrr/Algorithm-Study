/*
 * @author Minyeong Park
 * @date 2022.04.24.
 * N과 M (2)
 * 참고 : https://st-lab.tistory.com/115
 * 문제 링크 : https://www.acmicpc.net/problem/15650
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;       // 출력할 수열을 담는 배열
    static int N, M;

    static void func(int at, int depth) { // at은 현재 위치 (어디서부터 시작하는지를 의미하는 변수)
        if (depth == M) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
           arr[depth] = i;
           func(i + 1, depth + 1);
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