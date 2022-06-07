// chap08 (1) 예제 8_4 : 피보나치 함수 소스코드 (반복적)
public class n8_4 {
    public static long[] d = new long[100];

    public static void main(String[] args) {
        d[1] = 1;
        d[2] = 1;
        int n = 50;

        // 피보나치 함수를 반복문으로 구현
        for (int i = 3; i <= n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }
}
