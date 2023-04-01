/*
    백준 12852번 : 1로 만들기 2
    - 문제 유형 : 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색
    - 풀이 유형 : 다이나믹 프로그래밍
*/

import java.io.*;

public class _1로_만들기_2 {
    static class Num {
        int count;
        int previous;

        public Num(int count, int previous) {
            this.count = count;
            this.previous = previous;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine()); // 자연수 N 입력
        Num[] numbers = new Num[num + 1]; // DP 테이블
        numbers[1] = new Num(0, 0);

        // 2부터 num까지 연산 횟수 계산
        for (int i = 2; i <= num; i++) {
            numbers[i] = new Num(0, 0);
            // 가장 먼저 1을 빼는 경우의 결과
            numbers[i].count = numbers[i - 1].count + 1;
            numbers[i].previous = i - 1;
            // 가장 먼저 3으로 나누는 경우의 결과 (최솟값 저장)
            if (i % 3 == 0 && numbers[i / 3].count + 1 < numbers[i].count) {
                numbers[i].count = numbers[i / 3].count + 1;
                numbers[i].previous = i / 3;
            }
            // 가장 먼저 2로 나누는 경우의 결과 (최솟값 저장)
            if (i % 2 == 0 && numbers[i / 2].count + 1 < numbers[i].count) {
                numbers[i].count = numbers[i / 2].count + 1;
                numbers[i].previous = i / 2;
            }
        }

        // num의 연산 횟수 출력
        bw.write(numbers[num].count + "\n");
        // N을 1로 만드는 방법에 포함되어 있는 수 출력
        bw.write(num + " ");
        while (numbers[num].previous > 0) {
            bw.write(numbers[num].previous + " ");
            num = numbers[num].previous;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
