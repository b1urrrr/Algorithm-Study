import java.util.Scanner;
 
public class 베르트랑_공준 {
	/*
	n > 123456 이므로 2n 은 최대 246912 이다.
	0 부터 시작하므로 246912 + 1
	*/
	public static boolean[] prime = new boolean[246913];
    
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
        
		get_prime();	// 소수를 얻는 메소드 실행
		
		while(true) {
			int n = in.nextInt();
			if(n == 0) break;	// n 이 0 일경우 종료
            
			int count = 0;	// 소수 개수를 셀 변수
            
			for(int i = n + 1; i <= 2 * n; i++) {
				if(!prime[i]) count++;
			}
			System.out.println(count);
		}		
	}
	
	// 소수를 얻는 메소드
	public static void get_prime() {
		// 0 과 1 은 소수가 아니므로 ture
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
 
}
