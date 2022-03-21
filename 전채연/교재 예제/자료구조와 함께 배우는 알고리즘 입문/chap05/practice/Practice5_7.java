package chap05.practice;

import java.util.Scanner;

public class Practice5_7 {
    static final int INF = 1000;
    static void move(int count, int start, int end) {
        int[] steps = new int[INF];
        int[] starts = new int[INF];
        int[] ends = new int[INF];
        int ptr = 0;
        int step = 0;

        while (true) {
            // 첫 번째 재귀 함수 구현을 위해 스택에 step, start, end를 저장하는 구조
            if (step == 0 && count > 1) {
                steps[ptr] = step;
                starts[ptr] = start;
                ends[ptr++] = end;

                count--;
                end = 6 - start - end; // ???
                continue;
            }

            System.out.printf("원반[%d]을 %d기둥에서 %d기둥으로 옮김\n", count, start, end);

            // 두 번째 재귀 함수 구현을 위해 스택에 step, start, end를 저장하는 구조
            if (step == 1 && count > 1) {
                steps[ptr] = step;
                starts[ptr] = start;
                ends[ptr++] = end;

                count--;
                start = 6 - start - end;
                continue;
            }

            // 스택에 저장된 step, start, end를 꺼내 갱신시켜주는 구조
            do {
                if (ptr-- == 0) return; // 스택이 빈 경우 종료
                step = steps[ptr] + 1; // 다음 단계로 이동
                start = starts[ptr];
                end = ends[ptr];
                count++; // count는 처리될 때마다 1씩 감소했으므로 1 증가시킴
            } while (step == 2); // 이미 처리한 단계는 넘어감
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
    }
}
