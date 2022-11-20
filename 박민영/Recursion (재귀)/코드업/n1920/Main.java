/*
 * @author Minyeong Park
 * @date 2022.11.20.
 * (재귀함수) 2진수 변환
 * 문제 링크 : https://codeup.kr/problem.php?id=1920
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        to2(n);
        sb.reverse();
        System.out.println(sb);
    }

    static void to2(int num) {
        int div = num / 2;
        int remainder = num % 2;
        sb.append(remainder);
        if (div >= 2) {
            to2(div);
        } else if (div == 0) {
            return;
        } else {
            sb.append(div);
        }
    }
}