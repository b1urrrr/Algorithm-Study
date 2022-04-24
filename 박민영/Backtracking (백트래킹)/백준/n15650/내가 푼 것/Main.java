/*
 * @author Minyeong Park
 * @date 2022.04.24.
 * N과 M (2)
 * 문제 링크 : https://www.acmicpc.net/problem/15650
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit; // 방문했는지 여부를 담는 배열 (true : 방문 O, false : 방문 X)
    static int[] arr;       // 출력할 수열을 담는 배열

    static void func(int N, int M, int depth) {
        if (depth == M) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                if (depth == 0 || arr[depth - 1] < arr[depth])
                    func(N, M, depth + 1);
                visit[i] = false;
            }
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];

        func(N, M, 0);
    }
}