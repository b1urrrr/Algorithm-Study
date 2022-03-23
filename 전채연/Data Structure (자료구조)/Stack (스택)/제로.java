/*
    백준 10773번 : 제로
    - 문제 유형 : 자료 구조, 스택
*/

import java.io.*;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 정수의 개수
        Stack<Integer> stack = new Stack<>();        
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine()); // 정수 입력
            if (num == 0) stack.pop(); // 0이면 pop
            else stack.push(num); // 0이 아니면 push
        }

        int sum = 0;
        // 스택에 남아있는 모든 수를 합함
        while(!stack.empty()) {
            sum += stack.pop();
        }

        System.out.println(sum); // 출력
    }
}
