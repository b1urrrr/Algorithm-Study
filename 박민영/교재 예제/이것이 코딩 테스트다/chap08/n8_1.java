// chap08 (1) 예제 8_1 : 피보나치 함수 소스코드
public class n8_1 {
    // 피보나치 함수를 재귀함수로 구현
    public static int fibo(int x) {
        if (x == 1 || x == 2)
            return 1;
        return fibo(x-1) + fibo(x-2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(4));
    }
}
