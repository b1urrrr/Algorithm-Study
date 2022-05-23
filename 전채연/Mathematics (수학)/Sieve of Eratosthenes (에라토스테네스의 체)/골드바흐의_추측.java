import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class 골드바흐의_추측 {
	public static boolean[] prime = new boolean[10001];
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		get_prime();
 
		int T = Integer.parseInt(br.readLine());	// 테스트케이스
 
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int first_partition = n / 2;
			int second_partition = n / 2;
 
			while (true) {
            
				// 두 파티션이 모두 소수일 경우
				if (!prime[first_partition] && !prime[second_partition]) {
					sb.append(first_partition).append(' ').append(second_partition).append('\n');
					break;
				}
				first_partition--;
				second_partition++;
			}
		}
		System.out.print(sb);
	}
 
	// 에라토스테네스의 체
	public static void get_prime() {
		prime[0] = prime[1] = true;
 
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
 
}