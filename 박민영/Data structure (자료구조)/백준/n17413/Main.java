/*
 * @author Minyeong Park
 * @date 2022.09.28.
 * 단어 뒤집기 2
 * 원리 참고 : https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-17413%EB%B2%88-%EB%8B%A8%EC%96%B4-%EB%92%A4%EC%A7%91%EA%B8%B0-2-%EC%9E%90%EB%B0%94Java
 * 문제 링크 : https://www.acmicpc.net/problem/17413
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        boolean in_tag = false;
        while (index < input.length()) {
            if (input.charAt(index) == '<') {
                in_tag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(input.charAt(index));
            } else if (input.charAt(index) == '>') {
                in_tag = false;
                sb.append(input.charAt(index));
            } else if (input.charAt(index) == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(input.charAt(index));
            } else if (in_tag) {
                sb.append(input.charAt(index));
            } else if (!in_tag) {
                stack.push(input.charAt(index));
            }
            index++;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
