/*
    백준 9012번 : 괄호
    - 문제 유형 : 자료 구조, 스택
*/

import java.io.*;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            Boolean isWrong = false; // 잘못된 입력 여부
            Stack<Character> stack = new Stack<>();
            String s = br.readLine(); // 괄호 문자열 입력
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') stack.push(s.charAt(j)); // '('는 push
                else {
                    if (stack.empty()) {
                        // 앞에서 '('를 입력하지 않았는데 ')'가 입력된 경우
                        isWrong = true;
                        break;
                    }
                    stack.pop(); // ')'는 pop
                }
            }
            if (stack.empty() && !isWrong) bw.write("YES\n"); // 스택이 비었거나 잘못된 입력이 없는 경우 YES 출력
            else bw.write("NO\n"); // 아니면 NO 출력
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
