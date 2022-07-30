/*
 * @author Minyeong Park
 * @date 2022.07.30.
 * Hashing
 * 참고 : https://elena90.tistory.com/entry/JAVA-%EB%AC%B4%ED%95%9C%EB%8C%80-%EC%A0%95%EC%88%98-BigInteger-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0,
 *       https://kkh0977.tistory.com/161
 * 문제 링크 : https://www.acmicpc.net/problem/15829
 */

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        String str = sc.next();
        char[] ch_arr = new char[l];
        for (int i = 0; i < l; i++) {
            ch_arr[i] = str.charAt(i);
        }

        BigInteger r = BigInteger.ONE;
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < l; i++) {
            int a = ch_arr[i] - 'a' + 1;
            result = result.add(r.multiply(BigInteger.valueOf(a)));
            r = r.multiply(BigInteger.valueOf(31));
        }
        result = result.remainder(BigInteger.valueOf(1234567891));
        System.out.println(result);
    }
}