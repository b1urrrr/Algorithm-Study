/*
    백준 1541번 : 잃어버린 괄호
    - 문제 유형 : 그리디 알고리즘, 문자열
*/

import java.io.*;
import java.util.StringTokenizer;

public class 잃어버린_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // "-"를 기준으로 식을 분해해서 뺌 (첫 번째 수 제외)
        StringTokenizer subs = new StringTokenizer(br.readLine(), "-");
        int result = Integer.MAX_VALUE; // 결과값 저장 (중간값에 도출될 수 없는 값으로 초기화)

        while (subs.hasMoreTokens()) {
            // "+"를 기준으로 식을 분해해서 더함
            StringTokenizer adds = new StringTokenizer(subs.nextToken(), "+");
            int sum = Integer.parseInt(adds.nextToken());
            while (adds.hasMoreTokens()) {
                sum += Integer.parseInt(adds.nextToken());
            }
            // sum을 첫 번째 수이면 결과 변수에 대입, 아니면 결과 변수에 뺌
            if (result == Integer.MAX_VALUE) result = sum;
            else result -= sum;
        }

        // 결과 출력
        System.out.println(result);
    }
}
