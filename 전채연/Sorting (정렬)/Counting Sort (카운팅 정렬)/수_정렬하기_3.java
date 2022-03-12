/*
    백준 10989번 : 수 정렬하기 3
    - 문제 유형 : 정렬
    - 풀이 유형 : 카운팅 정렬 (Counting Sort)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class 수_정렬하기_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 수의 개수 입력
        int[] numbers = new int[10001]; // 각 수의 입력된 개수를 저장할 배열
        int max = -1; // 최댓값 변수

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine()); // 수 입력
            numbers[input]++; // 입력된 수와 동일한 인덱스를 가지는 numbers 요소를 1 증가시킴
            if (input > max) max = input; // 최댓값 탐색
        }

        // max보다 작은 자연수들의 입력된 개수를 검사
        for (int i = 1; i <= max; i++) {
            // 0개인 수들은 출력하지 않음
            if (numbers[i] == 0) continue;
            // 1개 이상인 수들은 개수만큼 반복하여 출력
            for (int j = 0; j < numbers[i]; j++) {
                bw.write(i + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
