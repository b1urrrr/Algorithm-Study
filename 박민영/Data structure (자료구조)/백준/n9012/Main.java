/*
 * @author Minyeong Park
 * @date 2022.07.08.
 * 괄호
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
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            stack = new Stack();
            for (int j = 0; j < str.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == '(' && str.charAt(j) == ')') {
                    stack.pop();
                } else {
                    stack.push(str.charAt(j));
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