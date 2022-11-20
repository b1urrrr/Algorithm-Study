/*
 * @author Minyeong Park
 * @date 2022.11.20.
 * (재귀함수) 피보나치 수열 (정석 풀이)
 * 출처 : https://codeup.kr/showsource.php?id=436448
 * 문제 링크 : https://codeup.kr/problem.php?id=1915&rid=0
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(recur(n));
    }

    static int recur(int count) {
        if (count <= 2) {
            return 1;
        }

        return recur(count - 1) + recur(count - 2);
    }
}