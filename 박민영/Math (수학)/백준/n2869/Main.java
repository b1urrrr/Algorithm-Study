/*
 * @author Minyeong Park
 * @date 2022.05.15.
 * 달팽이는 올라가고 싶다
 * 참고 : https://st-lab.tistory.com/75 , https://hyunipad.tistory.com/58
 * 문제 링크 : https://www.acmicpc.net/problem/2869
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int height = 0;

        // 원리
        // 4일차 낮 : (A - B) + (A - B) + (A - B) + A
        // X일차 낮 : (A - B) * (X - 1) + A
        // V = AX - A - BX + B + A
        // V = X * (A - B) + B
        // V - B = X * (A - B)
        // X = (V - B) / (A - B)
        int day = (V - B) / (A - B);

        // 나머지가 있을 경우 (잔여 높이가 있을 경우)
        if ((V - B) % (A - B) != 0)
            day++;

        System.out.println(day);
    }
}