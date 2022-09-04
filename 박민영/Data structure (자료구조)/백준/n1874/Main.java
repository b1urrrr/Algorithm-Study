/*
 * @author Minyeong Park
 * @date 2022.09.04.
 * 스택 수열
 * 원리 참고 : https://st-lab.tistory.com/182
 * 문제 링크 : https://www.acmicpc.net/problem/1874
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int start = 0; // 몇 번째까지 입력받았는지 알기 위한 변수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value > start) {
                // 해당 입력값까지 그 앞의 것들을 푸시
                for (int j = start + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                start = value;
            }
            // top에 있는 원소가 입력받은 값과 같지 않은 경우
            else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            // value 값까지 푸시가 되어 있다면 pop을 해준다.
            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}