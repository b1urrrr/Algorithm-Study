/*
    백준 4949번 : 균형잡힌 세상
    - 문제 유형 : 자료 구조, 스택
*/

import java.io.*;
import java.util.Stack;

public class 균형잡힌_세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = br.readLine(); // 문장 입력

        while (!sentence.equals(".")) {
            Boolean isCorrect = true; // 문자열의 균형이 이루어지는 여부 저장
            Stack<Character> stack = new Stack<>();
            A : for (int i = 0; i < sentence.length(); i++) {
                switch (sentence.charAt(i)) {
                    case '(': // 문장에 '('가 나온 경우 스택에 저장
                        stack.push('(');
                        break;
                    
                    case ')': // 문장에 ')'가 나온 경우 스택 pop
                        // 스택이 비어있으면 불균형한 문자열
                        if (stack.empty()) {
                            isCorrect = false;
                            break A;
                        }
                        // 스택에 '('이 pop되지 않으면 괄호의 균형이 맞지 않음
                        if (stack.pop() != '(') {
                            isCorrect = false;
                            break A;
                        }
                        break;
                    
                    case '[': // 문장에 '['가 나온 경우 스택에 저장
                        stack.push('[');
                        break;
                    
                    case ']': // 문장에 ']'가 나온 경우 스택 pop
                        // 스택이 비어있으면 불균형한 문자열
                        if (stack.empty()) {
                            isCorrect = false;
                            break A;
                        }
                        // 스택에 '['이 pop되지 않으면 괄호의 균형이 맞지 않음
                        if (stack.pop() != '[') {
                            isCorrect = false;
                            break A;
                        }
                        break;

                    default:
                }
            }
            // 스택이 비어있지 않으면 불균형한 문자열
            if (!stack.empty()) isCorrect = false;

            if (isCorrect) {
                bw.write("yes\n"); // 균형이 이루어진 문자열이면 "yes" 출력
            } else {
                bw.write("no\n"); // 균형이 이루어지지 않은 문자열이면 "no" 출력
            }

            // 문자열 입력
            sentence = br.readLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
