/*
 * @author Minyeong Park
 * @date 2022.05.08.
 * 네 번째 점
 * 참고 : https://st-lab.tistory.com/87
 * 문제 링크 : https://www.acmicpc.net/problem/3009
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] dots = new int[3][2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken()); // 가로 좌표
            dots[i][1] = Integer.parseInt(st.nextToken()); // 세로 좌표
        }

        // 네 번째 점의 x,y 좌표
        int x;
        int y;

        // 쌍을 이루지 않는 하나의 좌표가 4번째 점의 좌표가 된다!
        // x 좌표
        if (dots[0][0] == dots[1][0])
            x = dots[2][0];
        else if (dots[0][0] == dots[2][0])
            x = dots[1][0];
        else
            x = dots[0][0];

        // y 좌표
        if (dots[0][1] == dots[1][1])
            y = dots[2][1];
        else if (dots[0][1] == dots[2][1])
            y = dots[1][1];
        else
            y = dots[0][1];

        System.out.println(x + " " + y);
    }
}