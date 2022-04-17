/*
 * @author Minyeong Park
 * @date 2022.04.16.&17.
 * 한수
 * 원리 참고 : https://st-lab.tistory.com/54
 * 문제 링크 : https://www.acmicpc.net/problem/1065
 */

import java.io.*;

public class Main {
    static void func(int num) {
        if (num <= 99) {
            System.out.println(num);
            return;
        }

        int count = 99; // num이 99보다 크면 최소 개수는 일단 99개
        if (num == 1000)
            num = 999; // 어차피 1000은 등차수열이 아니고 이보다 큰 수는 입력받디 않으므로 num을 999로 변경함

        // 이제 100 ~ 999까지의 숫자만 판단하므로 3자리 숫자!
        for (int i = 100; i <= num; i++) {
            int n1 = i / 100;     // 첫번째 수 (백의 자리 수)
            int n2 = i / 10 % 10; // 2번째 수 (십의 자리 수)
            int n3 = i % 10;      // 3번째 수 (일의 자리 수)
            if (n1 - n2 == n2 - n3)
                count++;
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        func(N);
    }
}