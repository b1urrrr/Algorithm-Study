/*
 * @author Minyeong Park
 * @date 2022.07.05.
 * 검문 (혼자 힘으로 못 풀어서.. 다른 분의 해설로 이해하면서 공부함)
 * 참고 및 출처 : https://st-lab.tistory.com/155, https://pangsblog.tistory.com/62
 * 문제 링크 : https://www.acmicpc.net/problem/1934
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int gcdVal = arr[1] - arr[0]; // 음수가 되지 않도록 큰 수에서 작은 수로 빼줌

        for (int i = 2; i < n; i++) {
            // 직전의 최대공약수와 다음 수(arr[i] - arr[i - 1])의 최대공약수를 갱신
            gcdVal = gcd(gcdVal, arr[i] - arr[i-1]);
        }

        // 최대공약수의 약수들 찾기
        for (int i = 2; i <= gcdVal; i++) {
            if (gcdVal % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // 최대공약수 함수
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}