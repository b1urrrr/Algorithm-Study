/*
    백준 1929번 : 소수 구하기
    - 문제 유형 : 수학, 에라토스테네스의 채
*/

import java.util.Scanner;

public class 소수_구하기 {
    static boolean[] isNotPrime; // 소수가 아님을 표시하는 배열

    // 에라토스테네스의 채 함수
    static void seive_of_eratosthenes(int range) {
        // 0과 1은 소수가 아님을 표시
		isNotPrime[0] = isNotPrime[1] = true;
        // 2부터 i가 소수이면 자신의 배수는 소수가 아님을 표시
		for (int i = 2; i * i <= range; i++)
				if (!isNotPrime[i])
						for (int j = i * i; j <= range; j += i)
								isNotPrime[j] = true;
}
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int start = stdIn.nextInt(); // M 입력
        int end = stdIn.nextInt(); // N 입력
        isNotPrime = new boolean[end + 1];
        
        // 에라토스테네스의 채 함수 호출
        seive_of_eratosthenes(end);

        // 범위 내의 소수 출력
        for (int i = start; i <= end; i++)
            if (!isNotPrime[i]) System.out.println(i);
    }
}
