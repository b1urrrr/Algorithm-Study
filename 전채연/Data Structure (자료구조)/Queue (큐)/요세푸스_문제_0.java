/*
    백준 11866번 : 요세푸스 문제 0
    - 문제 유형 : 자료 구조, 큐
*/

import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스_문제_0 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int N = stdIn.nextInt(); // N 입력
        int[] numbers = new int[N + 1]; // 카운팅을 위한 배열 생성
        int idx = 1;

        int K = stdIn.nextInt(); // K 입력
        while (N > 0) {
            Queue<Integer> que = new LinkedList<>(); // 몇 번째 사람인지 셀 때마다 저장할 큐
            int k = K % N;
            if (k == 0) k = N;
            // k 번째 사람 찾기
            for (int i = 0; i < k; i++) {
                // 아직 세지 않은 사람을 찾을 때까지 인덱스 증가
                while (numbers[idx] != 0) {
                    idx++;
                    if (idx >= numbers.length) idx = 1;
                }
                // 수를 센 사람의 번호 큐에 저장
                que.add(idx);
                // 수를 센 사람은 numbers를 1로 변경
                numbers[idx]++;
            }
            while (!que.isEmpty()) {
                numbers[que.remove()]--; // 수를 셌던 사람들 numbers 0으로 복구
            }
            numbers[idx]++; // 제외할 사람은 numbers를 1로 다시 변경
            // 제외된 사람의 번호 출력
            if (--N > 0) sb.append(idx + ", ");
            else sb.append(idx + ">");
        }

        // 결과 출력
        System.out.println(sb);
    }
}
