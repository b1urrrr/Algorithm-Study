/*
 * @author Minyeong Park
 * @date 2023.02.04.
 * 분산처리 (다른 풀이 공부)
 * 참고 : https://ming9mon.tistory.com/104
 * 문제 링크 : https://www.acmicpc.net/problem/1009
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = 0;
            int r = 1;

            if (a % 10 == 0 || a % 10 == 1 || a % 10 == 5 || a % 10 == 6) {
                r = a % 10;    // a가 0,1,5,6 일경우 a의 값을 바로 집어넣음
            } else if (a % 10 == 4 || a % 10 == 9) { // 나머지 숫자는 2또는 4로 나눈 나머지를 구하여 for문으로 뒷자리를 구함
                c = b % 2;
                if (c == 0) c = 2;
            } else {
                c = b % 4;
                if (c == 0) c = 4;
            }

            for (int j = 0; j < c; j++) {
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