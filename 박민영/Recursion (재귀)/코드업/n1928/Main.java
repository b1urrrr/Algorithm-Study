/*
 * @author Minyeong Park
 * @date 2022.11.20.
 * (재귀함수) 우박수 (3n+1)
 * 문제 링크 : https://codeup.kr/problem.php?id=1928
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb.append(n + "\n");
        func(n);
    }

    static void func(int num) {
        if (num == 1) {
            System.out.println(sb);
            return;
        }

        if (num % 2 == 0) {
            num = num / 2;
            sb.append(num + "\n");
            func(num);
        } else {
            num = num * 3 + 1;
            sb.append(num + "\n");
            func(num);
        }
    }
}