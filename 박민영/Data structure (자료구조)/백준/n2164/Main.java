/*
 * @author Minyeong Park
 * @date 2022.07.29.
 * 카드2
 * 문제 링크 : https://www.acmicpc.net/problem/2164
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll();
            int first = q.poll();
            q.offer(first);
        }
        System.out.println(q.poll());
    }
}