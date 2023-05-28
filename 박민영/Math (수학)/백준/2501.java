/*
 * @author Minyeong Park
 * @date 2023.05.28.
 * 약수 구하기
 * 문제 링크 : https://www.acmicpc.net/problem/2501
 */


import java.io.*;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                q.offer(i);
            }
        }

        if (k > q.size()) {
            System.out.println(0);
            return;
        }

        int size = q.size();
        int[] arr = new int[q.size() + 1];
        for (int i = 1; i <= size; i++) {
            arr[i] = q.poll();
        }
        System.out.println(arr[k]);
    }
}