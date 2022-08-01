/*
 * @author Minyeong Park
 * @date 2022.08.01.
 * 균형잡힌 세상
 * 조금 참고 : https://st-lab.tistory.com/180
 * 문제 링크 : https://www.acmicpc.net/problem/4949
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        Loop1:
        while (!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println("no"); // 여기에서 원래 stack에 push해서 stack이 비어 있지 않게 했었는데 이러면 틀린 것이였다!
                        continue Loop1;
                    }
                    else
                        stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println("no");
                        continue Loop1;
                    }
                    else
                        stack.pop();
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}