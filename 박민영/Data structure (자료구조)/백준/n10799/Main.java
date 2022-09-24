/*
 * @author Minyeong Park
 * @date 2022.09.24.
 * 쇠막대기
 * 원리 참고 : https://steady-coding.tistory.com/10, https://binghedev.tistory.com/47
 * 문제 링크 : https://www.acmicpc.net/problem/10799
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장하는 스택
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                int poped_c = stack.pop();
                if (poped_c == i - 1) { // 레이저
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}