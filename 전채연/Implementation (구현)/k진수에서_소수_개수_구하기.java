/*
    프로그래머스 > 2022 KAKAO BLIND RECRUITMENT : k진수에서 소수 개수 구하기
*/

class k진수에서_소수_개수_구하기 {
    public boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
	    }
	    return true;
    }
    
    public String parseNumber (int n, int k) {
        String num = "";
        while (n > 0) {
            num = n % k + num;
            n /= k;
        }
        return num;
    }
    
    public int solution(int n, int k) {
        String number = parseNumber(n, k);
        int answer = 0, i = 0, j;
        
        while (i < number.length()) {
            for(j = i + 1; j < number.length() && number.charAt(j) != '0'; j++);
            if(isPrime(Long.parseLong(number.substring(i,j)))) answer++;
            i = j;
        }
        
        return answer;
    }
}