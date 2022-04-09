/*
 * @author Minyeong Park
 * @date 2022.04.10.
 * 셀프 넘버
 * 문제 링크 : https://www.acmicpc.net/problem/4673
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] numbers = new boolean[10001]; // true : 셀프 넘버 X , false : 셀프 넘버 O

        numbers[1] = false; // 1은 셀프 넘버
        self_number(numbers, 10000);

        for (int i = 1; i <= 10000; i++) {
            if (numbers[i] == false)
                System.out.println(i);
        }
    }

    static void self_number(boolean[] numbers, int max_num) {
        for (int i = 1; i <= 10000; i++) {
            int cur_num = i;
            int next_num = i;

            while (cur_num != 0) {
                next_num += cur_num % 10;
                cur_num /= 10;
            }

            if (next_num <= max_num) {
                numbers[next_num] = true; // 생성자 i를 통해 만들어진 수는 셀프 넘버 X
            } else {
                continue;
            }
        }
    }
}