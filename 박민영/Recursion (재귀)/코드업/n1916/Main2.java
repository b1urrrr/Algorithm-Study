/*
 * @author Minyeong Park
 * @date 2022.11.20.
 * (재귀함수) 피보나치 수열 (Large) (정석 풀이)
 * 문제 링크 : https://codeup.kr/problem.php?id=1916&rid=0
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int[] arr = new int[201];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println(recur(n));
    }

    static int recur(int count) {
        if (count <= 2) {
            return arr[count] = 1;
        }

        if (arr[count] == 0) {
            return arr[count] = (recur(count - 1) + recur(count - 2)) % 10009;
        }
        return arr[count];
    }
}