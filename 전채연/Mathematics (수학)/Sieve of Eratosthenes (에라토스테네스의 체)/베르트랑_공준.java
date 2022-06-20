/*
    백준 4948번 : 베르트랑 공준
    - 문제 유형 : 수학, 에라토스테네스의 체
*/

import java.io.*;
 
public class 베르트랑_공준 {
	static final int SIZE = 123456 * 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); // 자연수 n 입력

		// n이 0이면 종료
		while (num != 0) {
			int[] numbers = new int[num * 2 + 1];
			int count = num * 2 - num + 1; // n ~ 2n 자연수 개수 저장

			// 1 처리
			if (num == 1) count--;
			numbers[1]++;

			// i 배수 처리
			for (int i = 2; i <= num; i++) {
				for (int j = i; j <= num * 2; j += i) {
					numbers[j]++;
					if (j < num) continue;
					// 범위 안의 수가 소수에서 제외되면 count 감소
					if (numbers[j] == 1) count--;
				}
			}

			// n보다 크고 2n보다 작거나 같은 소수의 개수 출력
			System.out.println(count);
			num = Integer.parseInt(br.readLine()); // 자연수 n 재입력
		}
	}
}
