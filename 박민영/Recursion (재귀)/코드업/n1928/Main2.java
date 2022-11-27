/*
 * @author Minyeong Park
 * @date 2022.11.20.
 * (재귀함수) 우박수 (3n+1) (해답 풀이)
 * 문제 링크 : https://codeup.kr/problem.php?id=1928
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        func(n);
    }

    static void func(int num) {
        System.out.println(num);
        if (num == 1) {
            return;
        }

        if (num % 2 == 0) {
            func(num / 2);
        } else {
            func(num * 3 + 1);
        }
    }
}