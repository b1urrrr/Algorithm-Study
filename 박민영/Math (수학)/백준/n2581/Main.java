/*
 * @author Minyeong Park
 * @date 2022.04.03.
 * 소수
 * 문제 링크 : https://www.acmicpc.net/problem/2581
 */

import java.io.*;

public class Main {
    static boolean[] make_prime(int Max) {
        boolean[] Prime = new boolean[Max + 1]; // 0부터 시작하므로 +1

        // 0과 1은 소수가 아니므로 true
        Prime[0] = true;
        Prime[1] = true;

        for (int i = 2; i <= Math.sqrt(Max); i++) {
            // 이미 걸러진 배열일 경우 다음 반복문으로 건너뜀
            if (Prime[i] == true) continue;

            // 원래는 j = i * 2부터 시작 -> But 2의 배수가 걸러져있으므로 i의 제곱수부터 시작
            for (int j = i * i; j < Max + 1; j = j + i) {
                Prime[j] = true;
            }
        }

        // 소수라면 false, 아니라면 true
        return Prime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[N+1]; // 각 인덱스숫자가 소수인지 아닌지를 나타내는 배열
        arr = make_prime(N);

        int sum = 0; // 합
        int min = N; // 최솟값 (일단은 최댓값으로 초기화)
        for (int i = M; i <= N; i++) {
            if (arr[i] == false) {
                sum += i;
                if (i < min)
                    min = i;
            }
        }

        if (sum == 0) { // 소수가 없는 경우
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(min);
    }
}