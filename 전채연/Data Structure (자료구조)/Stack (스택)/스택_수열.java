/*
    백준 1874번 : 스택 수열
    - 문제 유형 : 자료 구조, 스택
*/

import java.io.*;
import java.lang.StringBuilder;
import java.util.Stack;

public class 스택_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // n 입력
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        boolean no = false;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine()); // 수열을 이루는 정수 입력

            if (no) continue;

            // 현재 count가 정수보다 작거나 같은 경우
            while (count <= num) {
                if (count > n) break;
                if (i < num) {
                    stack.add(count);
                    sb.append("+\n");
                }
                count++;
            }

            int pop = stack.pop();
            // pop한 수가 정수와 같은 경우
            if (pop == num) {
                sb.append("-\n");
            } 
            // pop한 수가 정수와 다른 경우
            else {
                no = true;
            }
        }

        // 결과 출력
        if (no) System.out.println("NO");
        else System.out.print(sb);
    }
}
