/*
 * @author Minyeong Park
 * @date 2022.12.01.
 * 파스칼의 삼각형 2
 * 문제 링크 : https://codeup.kr/problem.php?id=3702
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[51][51];
        for (int i = 1; i <= 50; i++) {
            arr[0][i] = 1;
            arr[i][0] = 1;
        }


    }

    static void recur(int r, int c) {

    }
}