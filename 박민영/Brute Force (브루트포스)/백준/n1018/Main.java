/*
 * @author Minyeong Park
 * @date 2022.04.06. & 04.08. & 04.10.
 * 체스판 다시 칠하기
 * 참고한 글 : https://st-lab.tistory.com/101
 * 문제 링크 : https://www.acmicpc.net/problem/1018
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] arr;
    public static int min = 64; // 몇 개나 틀렸는지 세는 수(64개가 다 틀리는 경우가 최대치)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2차원 배열에 입력 받기
        arr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == 'W')
                    arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i,j);
            }
        }
        System.out.println(min);
    }

    static void find(int x, int y) {
        int end_x = x + 8; // x부터 시작해서 행 기준 8칸만큼 떨어진 곳
        int end_y = y + 8; // y부터 시작해서 열 기준 8칸만큼 떨어진 곳
        int count = 0;     // 다시 칠해야 할 칸 개수

        boolean TF = arr[x][y]; // 8*8 범위 중, 첫 번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (arr[i][j] != TF)
                    count++;

                TF = !TF; // 다음 칸은 색이 바뀌므로 true -> false, false -> true로 변경함
            }
            TF = !TF;     // 다음 행의 시작 색이 바뀌므로 변경
        }

        // 첫 번째 칸을 기준으로 할 때 or 첫 번째 칸 색과 반대되는 색을 기준으로 할 때의 색칠할 개수 중 최솟값을 count에 저장
        count = Math.min(count, 64 - count);

        if (count < min)
            min = count;
    }
}