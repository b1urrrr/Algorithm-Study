/*
 * @author Minyeong Park
 * @date 2022.12.01.
 * 파스칼의 삼각형 2 (해설 풀이)
 * 문제 링크 : https://codeup.kr/problem.php?id=3702
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[51][51];

        System.out.println(recur(r, c));
    }

    static int recur(int r, int c) {
        if (arr[r][c] != 0) {
            return arr[r][c];
        }
        if (r == 1 || c == 1) return 1;
        return arr[r][c] = (recur(r-1, c) + recur(r, c-1)) % 100000000;
    }
}