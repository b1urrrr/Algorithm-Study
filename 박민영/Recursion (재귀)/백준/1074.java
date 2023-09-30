/*
 * @author Minyeong Park
 * @date 2023.10.01.
 * Z
 * 문제 링크 : https://www.acmicpc.net/problem/1074
 * 참고 : https://wiselog.tistory.com/133, https://ilmiodiario.tistory.com/140
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, r, c;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        answer = 0;
        int size = (int) Math.pow(2, n);

        recur(r, c, size);
        System.out.println(answer);
    }

    static void recur(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        if (r < size/2 && c < size/2) { // 1사분면에 있는 경우
            recur(r, c, size/2);
        } else if (r < size/2 && c >= size/2) { // 2사분면에 있는 경우
            answer += size * size / 4;
            recur(r, c - size/2, size/2); // 2사분면에서의 r,c 상대위치를 넘겨주어야 함 (r, c-size/2)
        } else if (r >= size/2 && c < size/2) { // 3사분면에 있는 경우
            answer += size * size / 4 * 2;
            recur(r - size/2, c, size/2); // 3사분면에서의 r,c 상대위치를 넘겨주어야 함 (r-size/2, c)
        } else { // 4사분면에 있는 경우
            answer += size * size / 4 * 3;
            recur(r - size/2, c - size/2, size/2); // 4사분면에서의 r,c 상대위치를 넘겨주어야 함 (r-size/2, c-size/2)
        }
    }
}