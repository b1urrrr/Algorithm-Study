/*
    백준 10845번 : 큐
    - 문제 유형 : 자료 구조, 큐
*/

import java.io.*;
import java.util.StringTokenizer;

public class 큐 {
    static class Queue {
        private int max; // 큐의 용량
        private int num; // 큐에 저장된 요소의 개수
        private int front; // 맨 앞 요소의 인덱스
        private int rear; // 맨 뒤 요소의 인덱스
        private int[] que; // 큐의 본체

        // 생성자
        public Queue(int capacity) {
            max = capacity;
            num = front = rear = 0;
            que = new int[max];
        }

        // 푸시 메서드
        public void push(int x) {
            que[rear++] = x;
            num++;
            if (rear == max) rear = 0;
        }

        // 팝 메서드
        public int pop() {
            if (num == 0) return -1;
            int output = que[front++];
            num--;
            if (front == max) front = 0;
            return output;
        }

        // 큐에 저장된 요소의 개수 반환 메서드
        public int size() {
            return num;
        }

        // 큐가 비어있는지 검사하는 메서드
        public int empty() {
            if (num == 0) return 1;
            return 0;
        }

        // 큐의 맨 앞 요소 반환 메서드
        public int front() {
            if (num == 0) return -1;
            return que[front];
        }

        // 큐의 맨 뒤 요소 반환 메서드
        public int back() {
            if (num == 0) return -1;
            return que[rear - 1];
        }
    }    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue que = new Queue(10001); // 큐 생성

        int N = Integer.parseInt(br.readLine()); // 명령의 수 입력
        for (int i = 0; i < N; i++) {
            String s = br.readLine(); // 명령어 입력
            StringTokenizer st = new StringTokenizer(s);

            switch(st.nextToken()) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    que.push(num);
                    break;
                
                case "pop":
                    bw.write(que.pop() + "\n");
                    break;

                case "size":
                    bw.write(que.size() + "\n");
                    break;
                
                case "empty":
                    bw.write(que.empty() + "\n");
                    break;

                case "front":
                    bw.write(que.front() + "\n");
                    break;
                
                case "back":
                    bw.write(que.back() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
