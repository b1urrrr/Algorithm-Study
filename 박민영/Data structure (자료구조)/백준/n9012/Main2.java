/*
 * @author Minyeong Park
 * @date 2022.07.08.
 * 괄호 (다른 코드 공부)
 * 출처 : https://st-lab.tistory.com/178
 * 문제 링크 : https://www.acmicpc.net/problem/9012
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        Loop1:
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            stack = new Stack();
            Loop2:
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '(')
                    stack.push(c);
                else if (stack.isEmpty()) {
                    System.out.println("NO");
                    continue Loop1;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}