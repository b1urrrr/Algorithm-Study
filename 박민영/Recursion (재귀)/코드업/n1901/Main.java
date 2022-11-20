/*
 * @author Minyeong Park
 * @date 2022.11.20.
 * (재귀 함수) 1부터 n까지 출력하기
 * 문제 링크 : https://codeup.kr/problem.php?id=1901
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        recur(1, n);
    }

    static void recur(int now, int end) {
        if (now > end) {
            return;
        }

        System.out.println(now);
        recur(now + 1, end);
    }
}