/*
    백준 16953번 : A → B
    - 문제 유형 : 그리디 알고리즘, 너비 우선 탐색
    - 풀이 유형 : 그리디 알고리즘
*/

import java.io.*;
import java.util.StringTokenizer;

public class A_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // A 입력
        int B = Integer.parseInt(st.nextToken()); // B 입력
        // A와 B의 최대값이 10^9이므로 큐를 활용한 BFS 활용 시 메모리 초과 발생
        // 그리디 아이디어로 풀이 가능

        int count = 1;
        while (A != B) {
            // B가 A보다 작아지면 경우의 수가 존재하지 않음
            if (A > B) {
                System.out.println(-1);
                return;
            }
            // 2로 나누는 경우
            if (B % 2 == 0) B /= 2;
            // 10으로 나누는 경우 (나머지가 1인 경우에만)
            else if (B % 10 == 1) B /= 10;
            // 가능한 연산이 존재하지 않는 경우
            else {
                System.out.println(-1);
                return;
            }

            // 연산 횟수 증가
            count++;
        }

        // A를 B로 바꾸는데 필요한 연산의 최솟값 출력 (+ 1)
        System.out.println(count);
    }    
}