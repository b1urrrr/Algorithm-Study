/*
 * @author Minyeong Park
 * @date 2022.09.11.
 * 괄호의 값
 * 원리 및 반례 참고 : https://loosie.tistory.com/349,
 *                  https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=yongyos&logNo=221454435252,
 *                  (설명 완전 잘 이해됨) https://ilmiodiario.tistory.com/27,
 *                  (반례) https://www.acmicpc.net/board/view/63152
 * 문제 링크 : https://www.acmicpc.net/problem/2504
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] arr = new char[input.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.charAt(i);
        }

        Stack<Character> stack = new Stack<>();
        int rst = 0; // 결과
        int tmp = 1; // 스택에 들어 있는 괄호의 값을 임시로 담는 변수
        try {
            for (int i = 0; i < arr.length; i++) {
                switch (arr[i]) {
                    case '(' :
                        tmp *= 2;
                        stack.push(arr[i]);
                        break;
                    case '[' :
                        tmp *= 3;
                        stack.push(arr[i]);
                        break;
                    case ')' :
                        if ((stack.isEmpty() && rst == 0) || stack.peek() != '(') {
                            throw new EmptyStackException();
                        } else if (arr[i - 1] == '(' || arr[i - 1] == '[') {
                            stack.pop();
                            rst += tmp;
                            tmp /= 2;
                        } else {
                            stack.pop();
                            tmp /= 2;
                        }
                        break;
                    case ']' :
                        if ((stack.isEmpty() && rst == 0) || stack.peek() != '[') {
                            throw new EmptyStackException();
                        } else if (arr[i - 1] == '(' || arr[i - 1] == '[') {
                            stack.pop();
                            rst += tmp;
                            tmp /= 3;
                        } else {
                            stack.pop();
                            tmp /= 3;
                        }
                        break;
                }
            }
            if (!stack.isEmpty()) {
                throw new EmptyStackException();
            }
        } catch (EmptyStackException e) {
            System.out.println(0);
            return;
        }

        System.out.println(rst);
    }
}