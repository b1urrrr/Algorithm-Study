/*
 * @author Minyeong Park
 * @date 2023.02.04.
 * 분산처리
 * 참고 : https://ming9mon.tistory.com/104
 * 문제 링크 : https://www.acmicpc.net/problem/1009
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 그냥 이 a^b를 구해서 하려고 했었는데 이러면 너무 값이 커진다.
            // 그래서 뒷자리만 가져오면 된다!
            // 숫자를 표현할 수 있는 자리수가 정해져 있기 때문에 제곱을 구할 때마다 10으로 나눈 나머지만 가지고 계산하면 된다.
            int r = 1;
            for (int j = 0; j < b; j++) {
                r = (r * a) % 10;
            }

            if (r == 0) {
                System.out.println(10);
            } else {
                System.out.println(r);
            }
        }
    }
}