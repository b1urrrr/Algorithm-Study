package chap05;

import java.util.Queue;
import java.util.LinkedList;

public class Example5_2 {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();

        que.add(5);
        que.add(2);
        que.add(3);
        que.add(7);
        que.remove();
        que.add(1);
        que.add(4);
        que.remove();

        // 먼저 들어온 순서대로 출력
        while (!que.isEmpty()) {
            System.out.println(que.remove());
        }
    }
}
