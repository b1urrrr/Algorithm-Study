/*
 * @author Minyeong Park
 * @date 2022.12.04.
 * 뒤집힌 덧셈 (다른 더 간결한 풀이)
 * 출처 : https://airzinc.tistory.com/entry/%EB%B0%B1%EC%A4%80-1357-JAVA
 * 문제 링크 : https://www.acmicpc.net/problem/1357
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int x = Rev(a);
        int y = Rev(b);
        int result = Rev(x+y);
        System.out.println(result);
    }

    static int Rev(int n) {
        String str = "";
        while (n > 0) {
            str += n % 10;
            n /= 10;
        }
        return Integer.parseInt(str);
    }
}