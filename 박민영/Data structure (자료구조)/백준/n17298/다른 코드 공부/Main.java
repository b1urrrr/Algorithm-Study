/*
 * @author Minyeong Park
 * @date 2022.06.19.
 * 오큰수 (다른 코드 공부)
 * 출처 : https://st-lab.tistory.com/196
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

        int[] stack = new int[n]; // 스택처럼 쓸 배열
        int top = -1; // 스택의 맨 위 원소를 가리키는 변수
        for (int i = 1; i <= n; i++) {
            while (top != -1 && arr[i] > arr[stack[top]]) {
                arr[stack[top]] = arr[i];
                top--;
            }
            top++;
            stack[top] = i;
        }

        for (int i = top; i >= 0; i--) {
            arr[stack[i]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}