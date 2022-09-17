/*
 * @author Minyeong Park
 * @date 2022.09.18.
 * 30
 * 참고 : 원리 - https://pangsblog.tistory.com/87
 *       BigInteger 입력 - https://www.acmicpc.net/blog/view/3
 * 문제 링크 : https://www.acmicpc.net/problem/10610
 */

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        String n_str = String.valueOf(n);
        boolean have_0 = false;
        int sum = 0;
        Integer[] arr = new Integer[n_str.length()];
        for (int i = 0; i < n_str.length(); i++) {
            if (n_str.charAt(i) == '0') {
                have_0 = true;
            }
            arr[i] = Integer.parseInt(n_str.charAt(i) + "");
            sum += arr[i];
        }
        if (!have_0 || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}