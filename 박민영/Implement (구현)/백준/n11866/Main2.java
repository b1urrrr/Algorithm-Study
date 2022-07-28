/*
 * @author Minyeong Park
 * @date 2022.07.28.
 * 요세푸스 문제 0 (다른 풀이 공부)
 * 출처 : https://st-lab.tistory.com/197
 * 문제 링크 : https://www.acmicpc.net/problem/11866
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        System.out.print("<");
        while (!q.isEmpty()) {
            // k-1번 앞에 있는 원소를 뒤로 보낸다.
            for (int i = 0; i < k-1; i++) {
                int val = q.poll();
                q.offer(val);
            }

            if (q.size() == 1) {
                System.out.print(q.poll());
            } else {
                System.out.print(q.poll() + ", ");
            }
        }
        System.out.print(">");
    }
}