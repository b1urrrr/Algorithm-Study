/*
 * @author Minyeong Park
 * @date 2023.05.28.
 * 약수들의 합
 * 문제 링크 : https://www.acmicpc.net/problem/9506
 */


import java.io.*;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;
        StringBuilder sb = new StringBuilder();
        while ((input = Integer.parseInt(br.readLine())) != -1) {
            int sum = 0;
            PriorityQueue<Integer> q = new PriorityQueue();
            for (int i = 1; i < input; i++) {
                if (input % i == 0) {
                    sum += i;
                    q.offer(i);
                }
            }

            if (sum == input) {
                sb.append(input + " = ");
                int size = q.size();
                for (int i = 0; i < size - 1; i++) {
                    sb.append(q.poll() + " + ");
                }
                sb.append(q.poll() + "\n");
            } else {
                sb.append(input + " is NOT perfect.\n");
            }
        }
        System.out.println(sb);
    }
}