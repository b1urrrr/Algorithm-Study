// chap05 (1) 큐 예제

import java.util.LinkedList;
import java.util.Queue;

public class n5_2 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(5); // 5 삽입
        q.offer(2); // 5 삽입
        q.offer(3); // 3 삽입
        q.offer(7); // 7 삽입
        q.poll(); // 삭제
        q.offer(1); // 1 삽입
        q.offer(4); // 4 삽입
        q.poll(); // 삭제

        // 먼저 들어온 원소부터 추출
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
