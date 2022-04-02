/*
    백준 10866번 : 덱
    - 문제 유형 : 자료 구조, 덱
*/

import java.io.*;
import java.util.StringTokenizer;

public class 덱 {
    static class Deque {
        private int size; // 저장된 요소의 개수
        private int front; // 맨 앞 요소의 인덱스
        private int rear; // 맨 뒤에 요소가 들어갈 인덱스
        private int[] que; // 덱 본체
        
        // 생성자
        public Deque() {
            this.que = new int[10000];
            this.size = this.front = this.rear = 0;
        }

        // 앞 쪽에 push
        public void push_front(int num) {
            if (--front < 0) front = 9999;
            que[front] = num;
            size++;
        }

        // 뒤 쪽에 push
        public void push_back(int num) {
            que[rear] = num;
            size++;
            if (++rear > 9999) rear = 0;
        }

        // 맨 앞의 요소 pop
        public int pop_front() {
            if (size == 0) return -1;
            int out = que[front];
            if (++front > 9999) front = 0;
            size--;
            return out;
        }

        // 맨 뒤의 요소 pop
        public int pop_back() {
            if (size == 0) return -1;
            if (--rear < 0) rear = 9999;
            size--;
            return que[rear];
        }

        // 저장된 요소의 개수 반환
        public int size() {
            return size;
        }

        // 덱이 비어있는지 검사
        public int empty() {
            if (size == 0) return 1;
            else return 0;
        }

        // 맨 앞의 요소 반환
        public int front() {
            if (size == 0) return -1;
            return que[front];
        }

        // 맨 뒤의 요소 반환
        public int back() {
            if (size == 0) return -1;
            int out;
            if (rear - 1 < 0) out = que[9999];
            else out = que[rear - 1];
            return out;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine()); // 명령의 수 입력
        Deque deque = new Deque(); // 덱

        for (int i = 0; i < repeat; i++) {
            String s = br.readLine(); // 명령 입력
            StringTokenizer st = new StringTokenizer(s);

            switch (st.nextToken()) {
                case "push_front":
                    deque.push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deque.push_back(Integer.parseInt(st.nextToken()));
                    break;
                
                case "pop_front":
                    bw.write(deque.pop_front() + "\n");
                    break;
                
                case "pop_back":
                    bw.write(deque.pop_back() + "\n");
                    break;
                
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                
                case "empty":
                    bw.write(deque.empty() + "\n");
                    break;

                case "front":
                    bw.write(deque.front() + "\n");
                    break;
                
                case "back":
                    bw.write(deque.back() + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
