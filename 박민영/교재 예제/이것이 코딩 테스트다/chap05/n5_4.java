// chap05 (1) 재귀 함수 종료 예제

public class n5_4 {
    public static void recursiveFunction(int i) {
        // 100번째 호출을 했을 때 종료되도록 종료 조건 명시
        if (i == 100) return;
        System.out.println(i + "번째 재귀 함수에서 " + (i+1) + "번째 재귀 함수를 호출합니다.");
        recursiveFunction(i+1);
        System.out.println(i+ "번째 재귀 함수를 종료합니다.");
    }
    public static void main(String[] args) {
        recursiveFunction(1);
    }
}
