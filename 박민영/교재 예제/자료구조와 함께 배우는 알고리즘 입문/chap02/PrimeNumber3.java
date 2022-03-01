public class PrimeNumber3 {
    public static void main(String[] args) {
        int counter = 0;            // 곱셈과 나눗셈의 횟수
        int ptr = 0;                // 찾은 소수의 개수
        int[] prime = new int[500]; // 소수를 저장하는 배열

        prime[ptr++] = 2; //2는 소수
        prime[ptr++] = 3; //3은 소수

        for (int n = 5; n <= 1000; n += 2) { // 대상은 홀수만
            boolean flag = false;
            for (int i = 1; prime[i] * prime[i] <= n; i++) {      // 이미 찾은 소수로 나누어보기
                counter += 2;           // 2씩 증가시키는 이유 : 곱셈 및 나눗셈 연산의 횟수를 반영함
                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {                     // 마지막까지 나누어 떨어지지 않음
                prime[ptr++] = n;            // 소수로 저장
                counter++;                   // 안쪽 for 문에 들어지가 않았으므로 여기에서 1 증가
            }
        }

        for (int i = 0; i < ptr; i++) System.out.println(prime[i]);

        System.out.println("곱셈과 나눗셈을 수행한 횟수 : " + counter);
    }
}
