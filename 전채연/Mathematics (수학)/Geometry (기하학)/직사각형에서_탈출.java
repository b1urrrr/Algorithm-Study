/*
    백준 1085번 : 직사각형에서 탈출
    - 문제 유형 : 수학, 기하학
*/

import java.util.Scanner;

public class 직사각형에서_탈출 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int x = stdIn.nextInt(); // x 좌표 입력
        int y = stdIn.nextInt(); // y 좌표 입력
        int w = stdIn.nextInt(); // w 좌표 입력
        int h = stdIn.nextInt(); // h 좌표 입력
        
        // 최소 경로 탐색
        int min = x;

        if (min > w - x) min = w - x;
        if (min > h - y) min = h - y;
        if (min > y) min = y;

        // 출력
        System.out.println(min);
    }
}
