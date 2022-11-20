/*
 * @author Minyeong Park
 * @date 2022.11.20.
 * (재귀함수) 2진수 변환 (해설 풀이)
 * 문제 링크 : https://codeup.kr/problem.php?id=1920
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        to2(n);
        return;
    }

    static void to2(int num) {
        if (num / 2 != 0) {
            to2(num / 2);
        }
        System.out.print(num % 2);
    }
}