/*
 * @author Minyeong Park
 * @date 2022.06.29.
 * 잃어버린 괄호 (다른 코드 공부 2)
 * 코드 참고 : https://st-lab.tistory.com/148
 * 문제 링크 : https://www.acmicpc.net/problem/1541
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        int sum = Integer.MAX_VALUE; // 초기 상태 여부 확인을 위한 값으로 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        while (subtraction.hasMoreTokens()) {
            int temp = 0;
            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

            while (addition.hasMoreTokens()) {
                temp += Integer.parseInt(addition.nextToken());
            }

            // 첫번째 토큰인 경우 temp 값이 첫 번째 수가 됨.
            if (sum == Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;
        }

        System.out.println(sum);
    }
}