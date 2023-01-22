/*
 * @author Minyeong Park
 * @date 2022.12.18.
 * 완전제곱수
 * 참고 : https://www.delftstack.com/ko/howto/java/double-to-int-java/
 * 문제 링크 : https://www.acmicpc.net/problem/1977
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int num = 1;
        long sum = 0;
        int min_result = 0;
        while (Math.pow(num, 2) < m) {
            num++;
        }
        min_result = (int) Math.pow(num, 2);

        while (Math.pow(num, 2) <= n) {
            sum += Math.pow(num, 2);
            num++;
        }

        if (min_result > n) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(min_result);
    }
}