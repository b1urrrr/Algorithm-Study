/*
 * @author Minyeong Park
 * @date 2022.11.06.
 * 카드 정렬하기
 * 원리 및 코드 참고 : https://www.acmicpc.net/board/view/90899, https://hidelookit.tistory.com/158
 * 문제 링크 : https://www.acmicpc.net/problem/1715
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        long sum = 0;
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            sum += a + b;
            pq.add(a + b); // 합한 묶음 다시 넣기
        }
        System.out.println(sum);
    }
}