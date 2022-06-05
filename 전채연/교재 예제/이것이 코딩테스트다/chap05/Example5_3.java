package chap05;

public class Example5_3 {
    static void recursive_function() {
        System.out.println("재귀 함수를 호출합니다.");
        recursive_function();
        // java.lang.StackOverflowError 발생
    }
    public static void main(String[] args) {
        recursive_function();
    }
}
