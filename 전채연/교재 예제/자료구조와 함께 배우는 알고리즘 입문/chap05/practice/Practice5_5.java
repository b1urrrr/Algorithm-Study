package chap05.practice;

import java.util.Scanner;

public class Practice5_5 {
    static final int INF = 1000;

    static void recur3(int n) {
        int[] nstk = new int[INF];
        int[] steps = new int[INF];
        int ptr = 0;
        int step = 0;

        while (true) {
            // 스택에 n과 step을 저장하기 위한 구조
            if (n > 0) {
                nstk[ptr] = n;
                steps[ptr] = step;
                ptr++;

                if (step == 0) n--;
                else if (step == 1) {
                    n -= 2;
                    step = 0; // recur3(n - 2)에 대해서 처음 단계부터 수행하기 위해 step을 0으로 설정.
                }
                continue;
            }
            
            // 스택에 저장된 n과 step을 꺼내고 적절한 처리를 해주는 구조
            do {
                n = nstk[ptr - 1];
                step = steps[--ptr] + 1;

                if (step == 2) {
                    System.out.println(n);
                    if (ptr <= 0) return;
                }
            } while (step == 2); // 다음 꺼내는 n도 출력을 해야하는지 검사하기 위한 조건
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("인자 : ");
        int num = stdIn.nextInt();
        recur3(num);
    }    
}
