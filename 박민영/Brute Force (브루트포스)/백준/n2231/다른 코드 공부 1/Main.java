/*
 * @author Minyeong Park
 * @date 2022.04.01.
 * 분해합 (다른 분 코드 1 : 0부터 N 직전까지 탐색하는 방식)
 * 참고 글 : https://st-lab.tistory.com/98
 * 문제 링크 : https://www.acmicpc.net/problem/2231
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int ctor = 0; // 생성자

        for (int i = 0; i < N; i++) {
            int number = i;
            int sum = 0;   // 각 자릿수 합 변수

            while (number != 0) {
                sum += number % 10; // 각 자릿수 더하기
                number /= 10;
            }

            if (sum + i == N) {
                ctor = i;
                break;
            }
        }
        bw.write(ctor + "");
        bw.flush();
    }
}