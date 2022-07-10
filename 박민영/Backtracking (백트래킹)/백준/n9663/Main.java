/*
 * @author Minyeong Park
 * @date 2022.07.09.
 * N-Queen
 * 원리 참고 및 출처 : https://st-lab.tistory.com/118
 * 문제 링크 : https://www.acmicpc.net/problem/9663
 */

import java.util.Scanner;

public class Main {
    static int count = 0;
    static int n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        n_queen(0);
        System.out.println(count);
    }

    static void n_queen(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            // Possibility() : 해당 열에서 i번째 행에 놓을 수 있는지를 검사하는 함수
            if (Possibility(depth)) {
                n_queen(depth + 1);
            }
        }
    }

    static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할 경우(같은 행에 존재할 경우)
            if (arr[col] == arr[i]) {
                return false;
            }

            // 대각선 상에 놓여 있는 경우 (열의 차와 행의 차가 같은 경우가 대각선에 놓여 있는 경우임)
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }

        return true;
    }
}