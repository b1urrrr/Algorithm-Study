/*
    백준 2231번 : 분해합
    - 문제 유형 : 브루트포스 알고리즘
*/

import java.io.*;

public class 분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // N 입력
        int result = 0; // 결과 저장 변수

        // 1부터 1000000까지 완전탐색
        for (int i = 1; i < 1000000; i++) {
            int sum = i; // N과 N의 각 자릿수의 합
            int iterator = i;
            while (iterator > 0) {
                sum += iterator % 10;
                iterator /= 10;
            }
        
            if (sum == num) { // 탐색 성공
                result = i;
                break;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
