/*
 * @author Minyeong Park
 * @date 2022.11.20.
 * (재귀함수) 피보나치 수열 (Large)
 * 문제 링크 : https://codeup.kr/problem.php?id=1916&rid=0
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    static BigInteger[] arr = new BigInteger[201];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Arrays.fill(arr, BigInteger.ZERO);
        System.out.println(recur(n).remainder(BigInteger.valueOf(10009)));
    }

    static BigInteger recur(int count) {
        if (count <= 2) {
            return arr[count] = BigInteger.ONE;
        }

        if (arr[count].equals(BigInteger.ZERO)) {
            return arr[count] = recur(count - 1).add(recur(count - 2));
        }
        return arr[count];
    }
}