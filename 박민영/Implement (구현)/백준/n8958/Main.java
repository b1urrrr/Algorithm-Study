/*
 * @author Minyeong Park
 * @date 2022.04.10.
 * OX퀴즈
 * 참고한 글 : https://st-lab.tistory.com/50
 * 문제 링크 : https://www.acmicpc.net/problem/8958
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            int count = 0; // 연속된 횟수
            int sum = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O')
                    count++;
                else count = 0; // X이면 연속 횟수를 0으로 초기화
                sum += count;
            }
            System.out.println(sum);
        }
    }
}
