/*
 * @author Minyeong Park
 * @date 2022.03.06.
 * 카드1 (다른 분 코드 참고해서 큐로 규현한 것)
 * https://www.acmicpc.net/problem/2161
 */


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) que.add(i);

        String a = "";

        while(que.size() != 1) {
            a += que.poll().toString() + "";
            que.add(que.poll());
        }
        System.out.println(a + que.poll());
    }
}
