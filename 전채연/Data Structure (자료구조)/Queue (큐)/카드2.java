/*
    백준 2164번 : 카드2
    - 문제 유형 : 자료 구조, 큐
*/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int num = stdIn.nextInt(); // 카드의 개수
        Queue<Integer> que = new LinkedList<>(); // 큐
        
        for (int i = 1; i <= num; i++) que.add(i); // 1부터 num까지의 수 큐에 저장
        
        while (que.peek() != null) {
            num = que.remove(); // 큐가 비어있지 않으면 맨 앞 장을 꺼냄
            // 큐가 비어있지 않으면 맨 앞 장을 맨 뒤로 옮김
            if (que.peek() != null) {
                num = que.remove();
                que.add(num);
            }
        }

        System.out.println(num); // 마지막으로 꺼낸 카드의 숫자 출력
    }
}