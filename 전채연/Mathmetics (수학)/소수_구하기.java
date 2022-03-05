/*
    백준 1929번 : 소수 구하기
    - 문제 유형 : 수학(에라토스테네스의 채 참고)
    - 풀이 유형 : n의 제곱근 이하의 어떤 소수로도 나누어떨어지지 않는 수 n
*/

import java.util.Scanner;

public class 소수_구하기 {
    static final int INF = 1000000; // 입력의 최댓값
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int start = stdIn.nextInt(); // M 입력
        int end = stdIn.nextInt(); // N 입력
        int count = 0; // 발견한 소수의 개수
        int[] prime = new int[INF]; // 소수를 저장할 배열
        
        // 가장 작은 소수인 2 저장 및 조건 만족 시 출력
        prime[count++] = 2;
        if (start <= 2) System.out.println(2);

        // 3 이상 end 이하의 수에 대하여 소수 여부 검사
        for (int i = 3; i <= end; i += 2) {
            boolean isPrime = true;
            // 자신의 제곱근 이하의 어떤 소수로도 나누어떨어지지 않음
            for (int j = 0; prime[j] * prime[j] <= i; j++) {
                if (i % prime[j] == 0) {
                    isPrime = false;
                    break;
                }  
            }
            // 소수 발견 시 저장 및 조건 만족 시 출력
            if (isPrime) {
                prime[count++] = i;
                if (start <= i) System.out.println(i);
            }
        }
    }
}
