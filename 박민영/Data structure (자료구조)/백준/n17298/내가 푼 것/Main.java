/*
 * @author Minyeong Park
 * @date 2022.06.19.
 * 오큰수
 * 원리 파악 및 코드 수정 참고 : https://st-lab.tistory.com/196
 * 문제 링크 : https://www.acmicpc.net/problem/17298
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack();
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}