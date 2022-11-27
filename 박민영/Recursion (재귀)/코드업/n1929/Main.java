/*
 * @author Minyeong Park
 * @date 2022.11.27.
 * (재귀함수) 우박수 (3n+1) (reverse)
 * 문제 링크 : https://codeup.kr/problem.php?id=1929
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        func(n);
    }

    static void func(int num) {
        if (num == 1) {
            System.out.println(num);
            return;
        }

        if (num % 2 == 1) {
            func(num * 3 + 1);
        } else {
            func(num / 2);
        }
        System.out.println(num);
    }
}