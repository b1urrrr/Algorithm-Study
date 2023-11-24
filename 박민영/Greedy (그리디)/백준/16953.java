/*
 * @author Minyeong Park
 * @date 2023.10.22.
 * A → B
 * 문제 링크 : https://www.acmicpc.net/problem/16953
 * 참고 : https://myeongju00.tistory.com/48, https://velog.io/@hyemin0111/%EB%B0%B1%EC%A4%80-16953%EB%B2%88-AB-JAVA
 */



import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long input = Integer.parseInt(st.nextToken());
        long output = Integer.parseInt(st.nextToken());
        long x = input;
        long y = output;
        int cnt = 1;

        while (x != y) {
            if (x > y) {
                cnt = -1;
                break;
            }

            String y_str = String.valueOf(y);

            if (y % 2 == 0) {
                y /= 2;
                cnt++;
            } else if (y_str.charAt(y_str.length() - 1) == '1') {
                y_str = y_str.substring(0, y_str.length() - 1);
                y = Integer.parseInt(y_str);
                cnt++;
            } else {
                cnt = -1;
                break;
            }
        }

        System.out.println(cnt);
    }
}