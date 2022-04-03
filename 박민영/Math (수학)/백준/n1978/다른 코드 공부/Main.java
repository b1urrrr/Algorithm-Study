/*
 * @author Minyeong Park
 * @date 2022.04.03.
 * 소수 찾기 (다른 코드 공부) (제곱근 이상의 수로는 나누지 않는 방법)
 * 참고 글 : https://st-lab.tistory.com/80
 * 문제 링크 : https://www.acmicpc.net/problem/1978
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num_arr = new int[N]; // N개의 수를 담는 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num_arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0; // 소수의 개수

        for (int i : num_arr) {
            boolean isPrime = true;

            // 1은 소수 X
            if (i == 1) {
                continue;
            }

            // 2 ~ Number의 제곱근까지 중 나누어 떨어지는 약수가 있는지 판별
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            // 위 두 조건에 걸리지 않으면 소수
            if (isPrime) count++;
        }

        System.out.println(count);
    }
}