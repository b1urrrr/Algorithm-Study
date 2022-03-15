/*
    백준 10828번 : 스택
    - 문제 유형 : 자료 구조, 스택
*/

import java.io.*;
import java.util.StringTokenizer;

public class 스택 {
    // 스택 정의
    static class Stack {
        private int max; // 스택 용량(최대값)
        private int ptr; // 스택 포인터
        private int[] stk; // 스택 본체

        // 생성자
        public Stack(int capacity) {
            max = capacity;
            ptr = 0;
            stk = new int[max];
        }

        // push 메서드
        public void push(int x) {
            stk[ptr++] = x;
        }

        // pop 메서드
        public int pop() {
            if (ptr == 0) return -1;
            return stk[--ptr];
        }

        // 데이터 수 반환 메서드
        public int size() {
            return ptr;
        }

        // 비었는지 검사하는 메서드
        public int empty() {
            if (ptr == 0) return 1;
            return 0;
        }

        // 다음으로 pop되는 값 반환 메서드
        public int top() {
            if (ptr == 0) return -1;
            return stk[ptr - 1];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 명령어의 개수 입력
        Stack stack = new Stack(10001); // 스택 생성

        for (int i = 0; i < N; i++) {
            String s = br.readLine(); // 명령어 입력
            StringTokenizer st = new StringTokenizer(s);
            switch (st.nextToken()) {
                case "push": // 푸시
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;

                case "pop": // 팝
                    bw.write(stack.pop() + "\n");
                    break;
                
                case "size": // 데이터 수 반환
                    bw.write(stack.size() + "\n");
                    break;
                
                case "empty": // 비었는지 검사
                    bw.write(stack.empty() + "\n");
                    break;

                case "top": // 다음으로 pop되는 값
                    bw.write(stack.top() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
